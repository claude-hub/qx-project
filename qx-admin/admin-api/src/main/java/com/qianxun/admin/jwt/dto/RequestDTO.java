package com.qianxun.admin.jwt.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

public class RequestDTO {
    @ApiModelProperty(value = "token", required = true)
    @NotBlank(message = "token不能为空")
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
