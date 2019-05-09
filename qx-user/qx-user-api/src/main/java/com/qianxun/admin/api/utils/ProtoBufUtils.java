package com.qianxun.admin.api.utils;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/08/19 18:40
 */
public class ProtoBufUtils {
    /**
     * ProtoBuffer object to POJO
     */
    public static <T> T fromProtoBuffer(GeneratedMessageV3 pbObject, Class<T> modelClass) {
        T model = null;

        try {
            model = modelClass.newInstance();
            Field[] modelFields = modelClass.getDeclaredFields();
            if (modelFields != null && modelFields.length > 0) {
                for (Field modelField : modelFields) {
                    String fieldName = modelField.getName();
                    String name = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class<?> fieldType = modelField.getType();
                    try {
                        Method pbGetMethod = pbObject.getClass().getMethod("get" + name);
                        Object value = pbGetMethod.invoke(pbObject);
                        String str = ObjectUtils.toString(value, "");
                        if(StringUtils.isNotBlank(str)) {
                            if (fieldType == Date.class) {
                                value = new Date(((Timestamp) value).getSeconds() * 1000);
                            }
                            Method modelSetMethod = modelClass.getMethod("set" + name, fieldType);
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
     */
    public static <T> T toProtoBuffer(Object model, Class<T> pbClass) {
        if (!GeneratedMessageV3.class.isAssignableFrom(pbClass)) {
            throw new RuntimeException("Not ProtoBuffer message type");
        }

        T pbObject = null;

        try {
            Object pbBuilder = pbClass.getDeclaredMethod("newBuilder").invoke(null);
            Field[] pbFields = model.getClass().getDeclaredFields();
            if (pbFields != null && pbFields.length > 0) {
                for (Field pbField : pbFields) {
                    String fieldName = pbField.getName();
                    String name = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class<?> fieldType = pbField.getType();
                    try {
                        Method modelGetMethod = model.getClass().getMethod("get" + name);
                        Object value = modelGetMethod.invoke(model);
                        if (value != null) {
                            if (fieldType == Object.class) {
                                fieldType = String.class;
                            }
                            if (fieldType == Integer.class) {
                                fieldType = int.class;
                            }
                            if (fieldType == Date.class) {
                                fieldType = Timestamp.class;
                                // object直接setDate会报错
                                value = Timestamps.fromMillis(((Date)value).getTime());
                            }
                            if (fieldType == Boolean.class){
                                fieldType = boolean.class;
                            }
                            Method pbBuilderSetMethod = pbBuilder.getClass().getMethod("set" + name, fieldType);
                            pbBuilderSetMethod.invoke(pbBuilder, value);
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
}
