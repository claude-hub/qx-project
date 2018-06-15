package com.qianxun.admin.dto.auth.request;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

public class AuthUserLoginInputDTO {
    @NotBlank(message = "登录名不能为空")
    @ApiModelProperty(value = "登录账号(用户名、手机号、邮箱)", required = true)
    String loginStr;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    String password;

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