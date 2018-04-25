package com.qianxun.dto;

import com.sun.istack.internal.NotNull;

public class UserEditDTO {

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

    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
}
