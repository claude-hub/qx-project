package com.qianxun.admin.entity;

import java.util.Date;

/**
 * 角色表
 *
 * @author cloudy
 * @date 2018-06-12 22:23:27
 */
public class SysRole {
    /**
     *
     */
    private Integer id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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
}