// package com.qianxun.config;

// import org.jasypt.util.text.BasicTextEncryptor;

// /**
//  * @author Cloudy
//  * Date: 2019/5/27 2:16
//  */
// public class Password {
//     public static void main(String[] args) {
//         BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
//         //加密所需的salt(盐)
//         textEncryptor.setPassword("cloudy");
//         //要加密的数据（数据库的用户名或密码）
//         String username = textEncryptor.encrypt("root");
//         String password = textEncryptor.encrypt("root");
//         System.out.println("username:"+username);
//         System.out.println("password:"+password);
//     }
// }
