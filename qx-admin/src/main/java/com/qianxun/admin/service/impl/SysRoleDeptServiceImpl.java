package com.qianxun.admin.service.impl;

import com.qianxun.admin.mapper.SysRoleDeptMapper;
import com.qianxun.admin.model.entity.SysRoleDept;
import com.qianxun.admin.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleDeptServiceImpl implements SysRoleDeptService {

    @Autowired
    private SysRoleDeptMapper sysRoleDeptMapper;

    @Override
    public boolean addSysRoleDept(SysRoleDept sysRoleDept) {
        return this.sysRoleDeptMapper.insert(sysRoleDept) > 0;
    }

    @Override
    public boolean editSysRoleDept(SysRoleDept sysRoleDept) {
        return sysRoleDeptMapper.updateByPrimaryKey(sysRoleDept) > 0;

    }

    @Override
    public List<SysRoleDept> findAllSysRoleDepts() {
        return sysRoleDeptMapper.selectAll();
    }

    @Override
    public SysRoleDept getSysRoleDept(int id) {
        return sysRoleDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysRoleDept(int id) {
        return sysRoleDeptMapper.deleteByPrimaryKey(id) > 0;
    }
}