package com.qianxun.admin.entity;

import java.util.Date;

/**
 * 用户权限表
 *
 * @author cloudy
 * @date 2018-06-12 22:49:20
 */
public class SysPermission {
    /**
     *
     */
    private Integer id;
    /**
     * 权限名
     */
    private String name;
    /**
     * 模块枚举值
     */
    private Integer module;
    /**
     * 描述
     */
    private String description;
    /**
     * 唯一标识
     */
    private String key;


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

    public void setModule(Integer module) {
        this.module = module;
    }

    public Integer getModule() {
        return module;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}