package com.qianxun.admin.dto.auth.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.Nullable;


import java.util.Date;

public final class AuthUserLoginDTO {
    @Nullable
    private Integer id;
    @Nullable
    private String name;
    @Nullable
    private String username;
    @Nullable
    private String phone;
    @Nullable
    private String email;
    @Nullable
    private String identification;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Nullable
    private Date resetPasswordSentAt;
    @Nullable
    private Integer signInCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Nullable
    private Date currentSignInAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Nullable
    private Date lastSignInAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Nullable
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Nullable
    private Date updatedAt;
    @Nullable
    private String currentToken;

    @Nullable
    public final Integer getId() {
        return this.id;
    }

    public final void setId(@Nullable Integer id) {
        this.id = id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(@Nullable String username) {
        this.username = username;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(@Nullable String phone) {
        this.phone = phone;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public final String getIdentification() {
        return this.identification;
    }

    public final void setIdentification(@Nullable String identification) {
        this.identification = identification;
    }

    @Nullable
    public final Date getResetPasswordSentAt() {
        return this.resetPasswordSentAt;
    }

    public final void setResetPasswordSentAt(@Nullable Date resetPasswordSentAt) {
        this.resetPasswordSentAt = resetPasswordSentAt;
    }

    @Nullable
    public final Integer getSignInCount() {
        return this.signInCount;
    }

    public final void setSignInCount(@Nullable Integer signInCount) {
        this.signInCount = signInCount;
    }

    @Nullable
    public final Date getCurrentSignInAt() {
        return this.currentSignInAt;
    }

    public final void setCurrentSignInAt(@Nullable Date currentSignInAt) {
        this.currentSignInAt = currentSignInAt;
    }

    @Nullable
    public final Date getLastSignInAt() {
        return this.lastSignInAt;
    }

    public final void setLastSignInAt(@Nullable Date lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }

    @Nullable
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final void setCreatedAt(@Nullable Date createdAt) {
        this.createdAt = createdAt;
    }

    @Nullable
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final void setUpdatedAt(@Nullable Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Nullable
    public final String getCurrentToken() {
        return this.currentToken;
    }

    public final void setCurrentToken(@Nullable String currentToken) {
        this.currentToken = currentToken;
    }
}