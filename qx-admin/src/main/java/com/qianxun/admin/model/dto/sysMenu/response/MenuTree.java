package com.qianxun.admin.model.dto.sysMenu.response;

import java.util.List;

public class MenuTree {
    /**
     * 菜单ID
     */
    private Integer menuId;
    /**
     * 父菜单ID
     */
    private Integer parentId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单权限标识
     */
    private String menuCode;
    /**
     * 请求链接
     */
    private String url;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private Integer type;
    /**
     * 0--正常 1--禁用
     */
    private Integer status;
    /**
     * 子菜单列表
     */
    private List<MenuTree> children;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }
}
