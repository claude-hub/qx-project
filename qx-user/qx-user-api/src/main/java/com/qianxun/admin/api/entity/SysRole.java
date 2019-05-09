package com.qianxun.admin.api.entity;

import java.util.Date;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cloudy
 * @date 2019-05-09 21:05:02
 */
@Data
public class SysRole implements Serializable {
    /**
     * 角色ID
     */
    private Integer id;
    /**
     * 角色码
     */
    private String roleCode;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 1-正常，-1-删除
     */
    private Integer status;
    /**
     *
     */
    private String dbSource;
}
