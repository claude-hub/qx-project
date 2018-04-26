package com.qianxun.entity;

import java.util.Date;

public class AuthUser {
    private Integer id;

    private String name;

    private String username;

    private String phone;

    private String email;

    private String passwordEncrypted;

    private String identification;

    private String resetPasswordToken;

    private Date resetPasswordSentAt;

    private Integer signInCount;

    private Date currentSignInAt;

    private Date lastSignInAt;

    private Date createdAt;

    private Date updatedAt;

    private String currentToken;

    public AuthUser(Integer id, String name, String username, String phone, String email, String passwordEncrypted, String identification, String resetPasswordToken, Date resetPasswordSentAt, Integer signInCount, Date currentSignInAt, Date lastSignInAt, Date createdAt, Date updatedAt, String currentToken) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.passwordEncrypted = passwordEncrypted;
        this.identification = identification;
        this.resetPasswordToken = resetPasswordToken;
        this.resetPasswordSentAt = resetPasswordSentAt;
        this.signInCount = signInCount;
        this.currentSignInAt = currentSignInAt;
        this.lastSignInAt = lastSignInAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.currentToken = currentToken;
    }

    public AuthUser() {
        super();
    }

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
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted == null ? null : passwordEncrypted.trim();
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken == null ? null : resetPasswordToken.trim();
    }

    public Date getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public void setResetPasswordSentAt(Date resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
    }

    public Integer getSignInCount() {
        return signInCount;
    }

    public void setSignInCount(Integer signInCount) {
        this.signInCount = signInCount;
    }

    public Date getCurrentSignInAt() {
        return currentSignInAt;
    }

    public void setCurrentSignInAt(Date currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    public Date getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(Date lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void setCurrentToken(String currentToken) {
        this.currentToken = currentToken == null ? null : currentToken.trim();
    }
}