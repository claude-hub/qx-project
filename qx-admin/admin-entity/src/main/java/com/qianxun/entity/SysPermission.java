package com.qianxun.entity;

import java.io.Serializable;

/**
 * sys_permission
 * @author 
 */
public class SysPermission implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}