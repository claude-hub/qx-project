package com.qianxun.admin.provider.service;

import com.qianxun.admin.api.entity.SysDept;

import java.util.List;

public interface SysDeptService{
    boolean addSysDept(SysDept sysDept);

    boolean editSysDept(SysDept sysDept);

    List<SysDept> findAllSysDepts();

    SysDept getSysDept(int id);

    boolean deleteSysDept(int id);
}
