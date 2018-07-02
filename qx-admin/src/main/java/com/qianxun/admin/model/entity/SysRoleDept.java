package com.qianxun.admin.model.entity;

/**
 * 角色与部门对应关系
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
public class SysRoleDept{
/**
 * 角色ID
 */
    private Integer roleId;
/**
 * 部门ID
 */
    private Integer deptId;


    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }
}