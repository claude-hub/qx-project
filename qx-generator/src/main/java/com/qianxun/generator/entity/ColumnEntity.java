package com.qianxun.generator.entity;

/**
 * 列的属性
 */
public class ColumnEntity {
    //列名
    private String columnName;
    //列名的jdbc小写类型，如int,varchar
    private String dataType;
    //列名的jdbc大写类型，如VARCHAR,INT
    private String dataUpperCaseType;
    //列名备注
    private String comments;

    //属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    //属性名称(第一个字母小写)，如：user_name => userName
    private String attrname;
    //属性的java简单类型，如Integer,Data
    private String attrType;
    //属性的java包含类名的类型，如java.lang.Integer,java.util.Date
    private String attrAllType;
    //auto_increment
    private String extra;
    //可空，与数据库查询出来的YES，NO匹配
    private String nullable;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataUpperCaseType() {
        return dataUpperCaseType;
    }

    public void setDataUpperCaseType(String dataUpperCaseType) {
        this.dataUpperCaseType = dataUpperCaseType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrname() {
        return attrname;
    }

    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getAttrAllType() {
        return attrAllType;
    }

    public void setAttrAllType(String attrAllType) {
        this.attrAllType = attrAllType;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }
}