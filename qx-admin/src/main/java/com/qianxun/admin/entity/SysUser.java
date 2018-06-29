package com.qianxun.admin.entity;

import java.util.Date;

/**
 * 用户表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */
public class SysUser {
    /**
     * 主键ID
     */
    private Integer userId;
    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证
     */
    private String identification;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 0-正常，-1-冻结
     */
    private Integer status;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 重置密码的token
     */
    private String resetPasswordToken;
    /**
     * 加密后的密码
     */
    private String passwordEncrypted;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 修改时间
     */
    private Date updatedAt;
    /**
     * 当前的token
     */
    private String currentToken;
    /**
     * 当前登录时间
     */
    private Date currentSignInAt;
    /**
     * 上一次登录时间
     */
    private Date lastSignInAt;
    /**
     * 累积登录次数
     */
    private Integer signInCount = 0;


    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
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

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken;
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentSignInAt(Date currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setLastSignInAt(Date lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public Date getLastSignInAt() {
        return lastSignInAt;
    }

    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public Integer getSignInCount() {
        return signInCount;
    }
}