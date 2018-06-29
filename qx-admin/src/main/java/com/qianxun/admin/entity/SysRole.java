package com.qianxun.admin.entity;

import java.util.Date;

/**
 * 
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */
public class SysRole{
/**
 * 
 */
    private Integer roleId;
/**
 * 角色名
 */
    private String roleName;
/**
 * 角色码
 */
    private String roleCode;
/**
 * 角色描述
 */
    private String roleDesc;
/**
 * 
 */
    private Date createdAt;
/**
 * 
 */
    private Date updatedAt;
/**
 * 删除标识（0-正常,1-删除）
 */
    private Integer status;


    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}