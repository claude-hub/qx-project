package com.qianxun.admin.service;

import com.qianxun.admin.entity.SysRoleDept;

import java.util.List;

public interface SysRoleDeptService{
    boolean addSysRoleDept(SysRoleDept sysRoleDept);

    boolean editSysRoleDept(SysRoleDept sysRoleDept);

    List<SysRoleDept> findAllSysRoleDepts();

    SysRoleDept getSysRoleDept(int id);

    boolean deleteSysRoleDept(int id);
}