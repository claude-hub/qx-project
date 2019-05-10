package com.qianxun.admin.api.utils;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/08/19 18:40
 */
public class ProtoBufUtils {
    /**
     * ProtoBuffer object to POJO
     * 支持pojo的继承，支持嵌套repeated
     */
    public static <T> T fromProtoBuffer(Object pbObject, Class<T> modelClass) {
        T model = null;
        try {
            model = modelClass.newInstance();
            Field[] modelFields = modelClass.getDeclaredFields();
            if(modelFields == null || modelFields.length == 0){
                modelFields = model.getClass().getSuperclass().getDeclaredFields();
            }
            if (modelFields != null && modelFields.length > 0) {
                for (Field modelField : modelFields) {
                    String fieldName = modelField.getName();
                    String upperName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class<?> fieldType = modelField.getType();
                    try {
                        Method getDescriptorForType = pbObject.getClass().getMethod("getDescriptorForType");
                        Descriptors.Descriptor descriptor = (Descriptors.Descriptor) getDescriptorForType.invoke(pbObject);
                        // 根据proto文件命名规范，使用的下划线命名
                        Descriptors.FieldDescriptor fd = descriptor.findFieldByName(toUnderline(fieldName));

                        Method pbGetMethod;
                        Object value;
                        // 判断是否是repeated类型
                        if (fd != null && fd.isRepeated()){
                            pbGetMethod = pbObject.getClass().getMethod("get" + upperName + "List");
                            Object pbValue = pbGetMethod.invoke(pbObject);
                            // 嵌套数组转化为java的pojo
                            Class<?> classType=Class.forName("com.qianxun.admin.api.entity." + upperName);
                            List<Object> pojo = new ArrayList<>();
                            List<Object> protoList = (List<Object>) pbValue; //数据为List集合
                            for (Object item : protoList) {
                                Object object = fromProtoBuffer(item, classType);
                                pojo.add(object);
                            }
                            value = pojo;

                        } else {
                            pbGetMethod = pbObject.getClass().getMethod("get" + upperName);
                            value = pbGetMethod.invoke(pbObject);
                        }
                        String str = value == null ? "" : value.toString();
                        if (str != null && !str.equals("0") && !str.equals("") && !str.equals("[]")) {
                            if (fieldType == Date.class) {
                                Timestamp timestamp = (Timestamp) value;
                                value = new Date(timestamp.getSeconds());
                            }
                            // java的class类
                            Method modelSetMethod = modelClass.getMethod("set" + upperName, fieldType);
                            modelSetMethod.invoke(model, value);
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    /**
     * POJO -> ProtoBuffer object
     * 支持pojo的继承，支持嵌套repeated
     */
    public static <T> T toProtoBuffer(Object model, Class<T> pbClass) {
        if (!GeneratedMessageV3.class.isAssignableFrom(pbClass)) {
            throw new RuntimeException("Not ProtoBuffer message type");
        }
        T pbObject = null;
        try {
            Object pbBuilder = pbClass.getDeclaredMethod("newBuilder").invoke(null);
            Method getDescriptorForType = pbBuilder.getClass().getMethod("getDescriptorForType");
            Descriptors.Descriptor descriptor = (Descriptors.Descriptor) getDescriptorForType.invoke(pbBuilder);

            Field[] modelFields = model.getClass().getDeclaredFields();
            if(modelFields == null || modelFields.length == 0){
                modelFields = model.getClass().getSuperclass().getDeclaredFields();
            }
            if (modelFields != null && modelFields.length > 0) {
                for (Field modelField : modelFields) {
                    // 小驼峰命名
                    String lowerName = modelField.getName();
                    // 大驼峰命名
                    String upperName = lowerName.substring(0, 1).toUpperCase() + lowerName.substring(1);
                    Class<?> fieldType = modelField.getType();
                    try {
                        Method modelGetMethod = model.getClass().getMethod("get" + upperName);
                        Object value = modelGetMethod.invoke(model);
                        if (value != null) {
                            // 根据proto文件命名规范，使用的下划线命名
                            Descriptors.FieldDescriptor fd = descriptor.findFieldByName(toUnderline(lowerName));

                            if (fd != null && fd.isRepeated() && ((List) value).size() > 0) {
                                Method[] pbBuilderMethods = pbBuilder.getClass().getMethods();
                                // java类型对应的add方法，如：addSysRole
                                String addFieldName = "add" + upperName;
                                for (Method mItem : pbBuilderMethods) {
                                    String pbMethodName = mItem.getName();
                                    Type[] types = mItem.getParameterTypes(); // 获取参数，可能是多个，所以是数组
                                    // 参数名一致，而且参数只有一个，而且是对象不是Builder
                                    if (pbMethodName.equals(addFieldName) && types.length == 1
                                            && !types[0].getTypeName().contains("Builder")) {
                                        Class paramType = mItem.getParameterTypes()[0];
                                        List<Object> pbList = new ArrayList<>();
                                        List<Object> protoList = (List<Object>) value; //数据为List集合

                                        for (Object item : protoList) {
                                            Object object = toProtoBuffer(item, paramType);
                                            pbList.add(object);
                                        }

                                        // 加入外层的对象
                                        Method addAll = pbBuilder.getClass().getMethod("addAll" + upperName, Iterable.class);
                                        addAll.invoke(pbBuilder, pbList);
                                    }
                                }
                            } else {
//                                if (fieldType == Integer.class) {
//                                    fieldType = int.class;
//                                }
//                                if (fieldType == Date.class) {
//                                    fieldType = Timestamp.class;
//                                    // object直接setDate会报错
//                                    value = Timestamps.fromMillis(((Date)value).getTime());
//                                }
//                                if (fieldType == Boolean.class){
//                                    fieldType = boolean.class;
//                                }
//                                Method pbBuilderSetMethod = pbBuilder.getClass().getMethod("set" + upperName, fieldType);
//                                pbBuilderSetMethod.invoke(pbBuilder, value);

                                if (fieldType == Date.class) {
                                    // 直接设置Date会报错
                                    value = Timestamps.fromMillis(((Date) value).getTime());
                                }
//                                采用下面的方法，set出来的字段是proto文件定义的字段命名规范。即：字段名采用下划线命名
                                Method me = pbBuilder.getClass().getMethod("setField", Descriptors.FieldDescriptor.class, Object.class);
                                me.invoke(pbBuilder, fd, value);
                            }
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            pbObject = (T) pbBuilder.getClass().getDeclaredMethod("build").invoke(pbBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pbObject;
    }

    /**
     * 驼峰命名转为下划线命名
     *
     * @param str
     * @return
     */
    private static String toUnderline(String str) {
        StringBuilder sb = new StringBuilder(str);
        int temp = 0;//定位
        if (!str.contains("_")) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isUpperCase(str.charAt(i))) {
                    sb.insert(i + temp, "_");
                    temp += 1;
                }
            }
        }
        return sb.toString().toLowerCase();
    }
}
