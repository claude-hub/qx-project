package com.qianxun.entity;

import java.util.Date;

public class AuthUserRole {
    private Integer id;

    private Integer authRoleId;

    private Integer authUserId;

    private Date createdAt;

    private Date updatedAt;

    public AuthUserRole(Integer id, Integer authRoleId, Integer authUserId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.authRoleId = authRoleId;
        this.authUserId = authUserId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public AuthUserRole() {
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

    public Integer getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(Integer authUserId) {
        this.authUserId = authUserId;
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