package com.qianxun.admin.model.dto.auth.response;

public class AuthUserInfo {
    private AuthUserLoginDTO user;
    /**
     * 用户角色列表
     */
    private String[] roles;
    /**
     * 权限列表
     */
    private String[] permissions;

    public AuthUserLoginDTO getUser() {
        return user;
    }

    public void setUser(AuthUserLoginDTO user) {
        this.user = user;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }
}
