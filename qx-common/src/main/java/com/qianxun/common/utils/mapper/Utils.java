package com.qianxun.common.utils.mapper;//package com.qianxun.admin.api.utils;
//
//import com.google.protobuf.Descriptors;
//import io.netty.util.internal.StringUtil;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Cloudy
// * Date: 2019/5/9 22:39
// */
//public class Utils {
//    @SuppressWarnings({"unchecked", "rawtypes"})
//
//    public static Object javaBeanToProtoBean(Object javaBean, Object protoBuilder) {
//        try {
//            Method mm = protoBuilder.getClass().getMethod("getDescriptorForType");
//
//
//            Descriptors.Descriptor descriptor = (Descriptors.Descriptor) mm.invoke(protoBuilder);
//
//
//            Field[] fields = javaBean.getClass().getDeclaredFields();
//
//            for (Field item : fields) {
//                try {
//                    String fName = item.getName();
//                    item.setAccessible(true);
//                    Object jObject = item.get(javaBean);
//                    if (null == jObject) {
//                        break;
//                    }
//                    String underline = HumpToUnderline(fName);
//                    Descriptors.FieldDescriptor fd = descriptor.findFieldByName(underline);
//                    if (null != fd) {
//                        if (fd.isRepeated()) {
//                            boolean isDefined = false;
//                            Method[] mmm = protoBuilder.getClass().getMethods();
//                            for (Method mItem : mmm) {
//
//                                try {
//                                    String mName = mItem.getName();
//                                    String mName1 = "add" + fName.substring(0, 1).toUpperCase() + fName.substring(1);
//                                    if (mName1.equals(mName) && mItem.getParameterTypes().length == 1) {
//                                        Class[] ccList = mItem.getParameterTypes();
//                                        Class cc = ccList[0];
//                                        Method me = cc.getMethod("newBuilder");
//                                        Object oBuilder = me.invoke(null);//获取自定义对象builder
//                                        List<Object> dList = (List<Object>) jObject; //数据为List集合
//                                        List<Object> pBeanList = new ArrayList<Object>();
//                                        for (Object oItem : dList) {
//                                            Object pBean = javaBeanToProtoBean(oItem, oBuilder);
//                                            pBeanList.add(pBean);
//                                        }
//
//                                        Method mee = protoBuilder.getClass().getMethod("addAll" + StringUtil.escapeCsv(fName), Iterable.class);
//                                        mee.invoke(protoBuilder, pBeanList);
//                                        isDefined = true;
//                                    }
//                                } catch (Exception e) {
//
//                                }
//
//                            }
//
//                            if (!isDefined) {
//                                try {
//                                    Method me = protoBuilder.getClass().getMethod("addAll" + StringUtil.escapeCsv(fName), Iterable.class);
//                                    me.invoke(protoBuilder, jObject);
//                                } catch (Exception e) {
////                                    LOG.info("this repeated field is a user-defined field");
//                                    e.printStackTrace();
//                                }
//                            }
//
//
//                        } else {
//                            boolean isDefined1 = false;
//                            try {
//                                //自定义对象继续需要通过builder来解析处理，回调
//                                Method bM = protoBuilder.getClass().getMethod("getFieldBuilder", Descriptors.FieldDescriptor.class);
//                                Object subBuilder = bM.invoke(protoBuilder, fd);
//                                Object pBean = javaBeanToProtoBean(jObject, subBuilder);
//
//                                Method me = protoBuilder.getClass().getMethod("setField", Descriptors.FieldDescriptor.class, Object.class);
//                                me.invoke(protoBuilder, fd, pBean);
//                                isDefined1 = true;
//                            } catch (Exception e) {
////                                LOG.info("this required field is not a user-defined field");
//                            }
//
//                            if (!isDefined1) {
//                                Method me = protoBuilder.getClass().getMethod("setField", Descriptors.FieldDescriptor.class, Object.class);
//                                me.invoke(protoBuilder, fd, jObject);
//                            }
//
//                        }
//                    }
//                } catch (Exception e) {
////                    LOG.error("javaBeanToProtoBean method  item reflect error, item name:" + item.getName());
//                }
//            }
//
//            Method buildM = protoBuilder.getClass().getMethod("build");
//            Object rObject = buildM.invoke(protoBuilder);
// /*    Method byteM = rObject.getClass().getMethod("toByteArray");
//            Object byteObject =  byteM.invoke(rObject);
//            byte[] pbByte = (byte[]) byteObject;  
//            String pbStr = new String(Base64.getEncoder().encode(pbByte), "UTF-8");*/
//            return rObject;
//        } catch (Exception e) {
//            e.printStackTrace();
////            LOG.error("convert javabean to protobuf bean error,e:", e);
//            return null;
//        }
//
//    }
//
//    /**
//     * 驼峰命名转为下划线命名
//     * @param para
//     * @return
//     */
//    public static String HumpToUnderline(String para){
//        StringBuilder sb=new StringBuilder(para);
//        int temp=0;//定位
//        if (!para.contains("_")) {
//            for(int i=0;i<para.length();i++){
//                if(Character.isUpperCase(para.charAt(i))){
//                    sb.insert(i+temp, "_");
//                    temp+=1;
//                }
//            }
//        }
//        return sb.toString().toLowerCase();
//    }
//}
