package com.qianxun.admin.api.dto.sysUser.request;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.qianxun.admin.api.dto.base.RequestDTO;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Cloudy
 */
@Data
public class SysUserUpdateInputDTO extends RequestDTO implements Serializable {
    @NotNull(message = "主键ID不能为空")
    @ApiModelProperty(value = "主键ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证")
    private String identification;

    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(value = "电话", required = true)
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

    @NotBlank(message = "加密后的密码不能为空")
    @ApiModelProperty(value = "加密后的密码", required = true)
    private String passwordEncrypted;

    @ApiModelProperty(value = "当前的token")
    private String currentToken;

    @ApiModelProperty(value = "当前登录时间")
    private Date currentSignInAt;

    @ApiModelProperty(value = "上一次登录时间")
    private Date lastSignInAt;

    @ApiModelProperty(value = "累积登录次数")
    private Integer signInCount;

    /**
     * 乐观锁
     */
    @Version
    @ApiModelProperty(value = "乐观锁", required = true)
    @NotNull(message = "乐观锁版本不能为空")
    private Integer version;

    @ApiModelProperty(value = "角色列表")
    private List<Integer> roleIds;

    @ApiModelProperty(value = "特殊权限列表")
    private List<Integer> permissionIds;
}
