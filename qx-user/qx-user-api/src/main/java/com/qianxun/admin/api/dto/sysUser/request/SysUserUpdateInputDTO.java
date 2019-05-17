package com.qianxun.admin.api.dto.sysUser.request;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Cloudy
 */
@Data
public class SysUserUpdateInputDTO implements Serializable {
    @NotNull(message = "主键ID不能为空")
    @ApiModelProperty(value = "主键ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证")
    private String identification;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "0-正常，-1-冻结")
    private Integer locked;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "重置密码的token")
    private String resetPasswordToken;

    @ApiModelProperty(value = "密码")
    private String passwordEncrypted;

    @NotNull(message = "上此更新的时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间", required = true)
    private Date updatedAt;

    @ApiModelProperty(value = "当前的token")
    private String currentToken;
}
