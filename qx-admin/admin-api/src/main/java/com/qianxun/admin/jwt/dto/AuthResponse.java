package com.qianxun.admin.jwt.dto;

import java.io.Serializable;

/**
 * 认证的响应结果
 */
public class AuthResponse implements Serializable {

    /**
     * jwt token
     */
    private String token;

    /**
     * 用于客户端混淆md5加密

     */
    private String randomKey;

    public String getToken() {
        return this.token;
    }

    public String getRandomKey() {
        return randomKey;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRandomKey(String randomKey) {
        this.randomKey = randomKey;
    }
}