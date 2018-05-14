package com.qianxun.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

public class UserLoginInputDTO {
    @ApiModelProperty(value = "用户名，手机号，邮箱")
    @NonNull
    private String loginStr;

    @ApiModelProperty(value = "密码")
    @NonNull
    private String password;

    public String getLoginStr() {
        return loginStr;
    }

    public void setLoginStr(String loginStr) {
        this.loginStr = loginStr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
