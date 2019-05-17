package com.qianxun.common.utils.mapper;

import cn.hutool.core.util.ArrayUtil;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/08/19 18:40
 */
@Slf4j
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
            Field[] superModelFields = modelClass.getSuperclass().getDeclaredFields();
            modelFields = ArrayUtil.addAll(modelFields, superModelFields);
            Method[] methods = pbObject.getClass().getMethods();
            if (modelFields != null && modelFields.length > 0) {
                for (Field modelField : modelFields) {
                    String fieldName = modelField.getName();
                    String upperName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class<?> fieldType = modelField.getType();
                    Type type = modelField.getGenericType(); // 获取属性的参数类型（java.lang.List<com.qianxun.api.sysRole>）

                    try {
                        Method getDescriptorForType = pbObject.getClass().getMethod("getDescriptorForType");
                        Descriptors.Descriptor descriptor = (Descriptors.Descriptor) getDescriptorForType.invoke(pbObject);
                        // 根据proto文件命名规范，使用的下划线命名
                        Descriptors.FieldDescriptor fd = descriptor.findFieldByName(toUnderline(fieldName));

                        Method pbGetMethod = null;
                        Object value = null;
                        // 判断是否是repeated类型
                        if (fd != null && fd.isRepeated()) {
                            pbGetMethod = pbGetMethod(methods, "get" + upperName + "List");
                            if (pbGetMethod == null) {
                                continue;
                            }
                            Object pbValue = pbGetMethod.invoke(pbObject);
                            if (type instanceof ParameterizedType) {
                                ParameterizedType pt = (ParameterizedType) type;
                                //得到属性泛型里的class类型对象
                                Class<?> classType = (Class) pt.getActualTypeArguments()[0];
                                // 嵌套数组转化为java的pojo
                                List<Object> pojo = new ArrayList<>();
                                List<Object> protoList = (List<Object>) pbValue; //数据为List集合
                                if(classType == Integer.class || classType == String.class || classType == Date.class){
                                    pojo.addAll(protoList);
                                }else {
                                    for (Object item : protoList) {
                                        Object object = fromProtoBuffer(item, classType);
                                        pojo.add(object);
                                    }
                                }
                                value = pojo;
                            }
                        } else {
                            pbGetMethod = pbGetMethod(methods, "get" + upperName);
                            if (pbGetMethod == null) {
                                continue;
                            }
                            value = pbGetMethod.invoke(pbObject);
                        }
                        String str = value == null ? "" : value.toString();
                        if (str != null && !str.equals("0") && !str.equals("") && !str.equals("[]")) {
                            if (fieldType == Date.class) {
                                Timestamp timestamp = (Timestamp) value;
                                value = new Date(timestamp.getSeconds() * 1000);
                            }
                            // java的class类
                            Method modelSetMethod = modelClass.getMethod("set" + upperName, fieldType);
                            modelSetMethod.invoke(model, value);
                        }
                    } catch (NoSuchMethodException e) {
                        log.error("NoSuchMethodException ex={}", e.getMessage(), e);
                    }
                }
            }
        } catch (Exception e) {
            log.error("fromProtoBuffer filed ex={}", e.getMessage(), e);
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
            Field[] superModelFields = model.getClass().getSuperclass().getDeclaredFields();
            modelFields = ArrayUtil.addAll(modelFields, superModelFields);
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
                                        if(paramType == int.class || paramType == String.class || paramType == Date.class){
                                            pbList.addAll(protoList);
                                        }else {
                                            for (Object item : protoList) {
                                                Object object = toProtoBuffer(item, paramType);
                                                pbList.add(object);
                                            }
                                        }
                                        // 加入外层的对象
                                        Method addAll = pbBuilder.getClass().getMethod("addAll" + upperName, Iterable.class);
                                        addAll.invoke(pbBuilder, pbList);
                                    }
                                }
                            } else {
                                if (fieldType == Date.class) {
                                    // 直接设置Date会报错
                                    value = Timestamps.fromMillis(((Date) value).getTime());
                                }
                                Method me = pbBuilder.getClass().getMethod("setField", Descriptors.FieldDescriptor.class, Object.class);
                                try {
                                    me.invoke(pbBuilder, fd, value);
                                } catch (InvocationTargetException e) {
                                    log.error("proto field can`t equals java POJO fieldName={}", lowerName, e.getMessage(), e);
                                    continue;
                                }

                            }
                        }
                    } catch (NoSuchMethodException e) {
                        log.error("NoSuchMethodException filed ex={}", e.getMessage(), e);
                    }
                }
            }
            pbObject = (T) pbBuilder.getClass().getDeclaredMethod("build").invoke(pbBuilder);
        } catch (Exception e) {
            log.error("toProtoBuffer failed ex={}", e.getMessage(), e);
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

    /**
     * 判断pb中是否有该get方法
     *
     * @param methods
     * @param methodName
     * @return
     */
    private static Method pbGetMethod(Method[] methods, String methodName) {
        for (Method mItem : methods) {
            String pbMethodName = mItem.getName();
            if (pbMethodName.equals(methodName)) {
                return mItem;
            }
        }
        return null;
    }
}
