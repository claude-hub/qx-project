package com.qianxun.admin.api.entity;

import java.util.Date;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cloudy
 * @date 2019-05-06 22:58:30
 */
@Data
public class SysDept implements Serializable {
    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private Integer parentId;
    /**
     *
     */
    private Integer sort;
    /**
     *
     */
    private Date createdAt;
    /**
     *
     */
    private Date updatedAt;
    /**
     * 是否删除  -1：已删除  0：正常
     */
    private Integer status;
    /**
     *
     */
    private String dbSource;
}
