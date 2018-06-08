package com.qianxun.admin.dto.user;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;


public class SysUserAddInputDTO {
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(value = "电话", required = true)
    private String phone;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "电子邮件")
    private String email;

    @ApiModelProperty(value = "身份证")
    private String identification;

    @ApiModelProperty(value = "角色id列表")
    private List<Integer> roleIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
