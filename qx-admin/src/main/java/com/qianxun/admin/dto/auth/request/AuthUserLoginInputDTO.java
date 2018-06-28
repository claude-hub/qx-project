package com.qianxun.admin.dto.auth.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

public class AuthUserLoginInputDTO {
    @NotBlank(message = "登录名不能为空")
    @ApiModelProperty(value = "登录账号(用户名、手机号、邮箱)", required = true)
    String loginStr;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    String password;

    @ApiModelProperty(value = "验证码")
    String captcha;

    @ApiModelProperty(value = "记住密码")
    Boolean remember = false;

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

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }
}