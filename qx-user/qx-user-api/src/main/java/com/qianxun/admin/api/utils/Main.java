package com.qianxun.admin.api.utils;

import java.lang.reflect.Field;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/09/19 14:18
 */
public class Main {
    public static void main(String[] arg){
        Integer i = 1;
        Field[] pbFields = i.getClass().getDeclaredFields();
        System.out.println(pbFields);
    }
}
