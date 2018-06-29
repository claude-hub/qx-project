package com.qianxun.admin.service.impl;

import com.qianxun.admin.dao.SysDeptMapper;
import com.qianxun.admin.entity.SysDept;
import com.qianxun.admin.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public boolean addSysDept(SysDept sysDept) {
        return this.sysDeptMapper.insert(sysDept) > 0;
    }

    @Override
    public boolean editSysDept(SysDept sysDept) {
        return sysDeptMapper.updateByPrimaryKey(sysDept) > 0;

    }

    @Override
    public List<SysDept> findAllSysDepts() {
        return sysDeptMapper.selectAll();
    }

    @Override
    public SysDept getSysDept(int id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysDept(int id) {
        return sysDeptMapper.deleteByPrimaryKey(id) > 0;
    }
}