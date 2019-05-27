package com.qianxun.admin.api.dto.authUser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Cloudy
 * Date: 2019/5/27 22:00
 */
@Data
public class AuthUserLoginInputDTO implements Serializable {
    @NotBlank(message = "登录名不能为空")
    @ApiModelProperty(value = "登录账号(用户名、手机号、邮箱)", required = true)
    private String loginStr;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
