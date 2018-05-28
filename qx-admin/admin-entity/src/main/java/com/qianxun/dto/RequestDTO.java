package com.qianxun.dto;

import com.qianxun.utils.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

public class RequestDTO extends BaseDTO {
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
