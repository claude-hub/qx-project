package com.qianxun.entity;

import java.util.Date;

public class AuthRolePermission {
    private Integer id;

    private Integer authRoleId;

    private Integer authPermissionId;

    private Date createdAt;

    private Date updatedAt;

    public AuthRolePermission(Integer id, Integer authRoleId, Integer authPermissionId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.authRoleId = authRoleId;
        this.authPermissionId = authPermissionId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public AuthRolePermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthRoleId() {
        return authRoleId;
    }

    public void setAuthRoleId(Integer authRoleId) {
        this.authRoleId = authRoleId;
    }

    public Integer getAuthPermissionId() {
        return authPermissionId;
    }

    public void setAuthPermissionId(Integer authPermissionId) {
        this.authPermissionId = authPermissionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}