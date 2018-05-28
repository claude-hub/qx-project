package com.qianxun.utils.properties;


import org.springframework.context.annotation.Configuration;

/**
 * jwt相关配置
 */
@Configuration
public class JwtProperties {
    private String header = "Authorization";

    private String secret = "defaultSecret";

    private Long expiration = 604800L;

    private String md5Key = "randomKey";

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }
}