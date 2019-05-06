package com.qianxun.admin.provider.service.impl;

import com.qianxun.admin.provider.mapper.SysDeptMapper;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.admin.provider.service.SysDeptService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import java.util.List;

@Service
@AllArgsConstructor
public class SysDeptServiceImpl implements SysDeptService {
    private final SysDeptMapper sysDeptMapper;

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
