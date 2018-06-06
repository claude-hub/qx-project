package com.qianxun.entity;

import java.util.Date;

/**
 * 表数据
 */
public class DBTableEntity {
    /**
     * 表名
     */
    private String tableName;
    private String engine;
    /**
     * 表创建时间
     */
    private Date createTime;
    /**
     * 表备注
     */
    private String tableComment;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }
}
