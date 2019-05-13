package com.qianxun.admin.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianxun.admin.api.dto.extend.SysDeptDTO;
import com.qianxun.admin.api.dto.sysDept.request.SysDeptQueryInputDTO;
import com.qianxun.admin.api.dto.sysDept.request.SysDeptSearchByIdDTO;
import com.qianxun.admin.api.entity.SysDept;

/**
 * @author Cloudy
 * Date 2019-05-13 22:13:53
 */
public interface SysDeptService extends IService<SysDept> {

    SysDeptDTO searchById(SysDeptSearchByIdDTO inputDTO);

    Boolean saveSysDept(SysDeptDTO sysDeptDTO);

    IPage getSysDepts(Page page, SysDeptQueryInputDTO inputDTO);

    Boolean updateSysDept(SysDeptDTO sysDeptDTO);
}
