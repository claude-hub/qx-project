package com.qianxun.admin.entity;

import java.util.Date;

/**
 * 部门管理
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
public class SysDept{
/**
 * 
 */
    private Integer deptId;
/**
 * 
 */
    private Integer parentId;
/**
 * 部门名称
 */
    private String name;
/**
 * 排序
 */
    private Integer orderNum;
/**
 * 创建时间
 */
    private Date createdAt;
/**
 * 修改时间
 */
    private Date updatedAt;
/**
 * 是否删除  -1：已删除  0：正常
 */
    private Integer status;


    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
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