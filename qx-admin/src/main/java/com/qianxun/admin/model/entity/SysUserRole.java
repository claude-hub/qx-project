package com.qianxun.admin.model.entity;

/**
 * 用户角色表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */
public class SysUserRole{
/**
 * 用户ID
 */
    private Integer userId;
/**
 * 角色ID
 */
    private Integer roleId;


    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }
}