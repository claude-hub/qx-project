package com.qianxun.admin.model.entity;

/**
 * 角色菜单表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
public class SysRoleMenu{
/**
 * 角色ID
 */
    private Integer roleId;
/**
 * 菜单ID
 */
    private Integer menuId;


    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuId() {
        return menuId;
    }
}