package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.sysDept.request.SysDeptQueryInputDTO;
import com.qianxun.admin.api.entity.SysDept;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Claude
 * email: 314705487@qq.com
 * Date: 05/10/19 9:30
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {
    IPage getSysDeptsWithLang(Page page, @Param("inputDTO") SysDeptQueryInputDTO inputDTO);
}
