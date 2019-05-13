package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.extend.SysDeptDTO;
import com.qianxun.admin.api.dto.sysDept.request.SysDeptQueryInputDTO;
import com.qianxun.admin.api.entity.SysDept;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/10/19 9:31
 */
public interface SysDeptService extends IService<SysDept> {

    Boolean saveSysDept(SysDeptDTO sysDeptDTO);

    IPage getSysDepts(Page page, SysDeptQueryInputDTO inputDTO);

    Boolean updateSysDept(SysDeptDTO sysDeptDTO);
}
