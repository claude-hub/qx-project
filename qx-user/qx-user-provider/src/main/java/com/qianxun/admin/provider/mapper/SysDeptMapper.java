package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.extend.SysDeptDTO;
import com.qianxun.admin.api.dto.sysDept.request.SysDeptQueryInputDTO;
import com.qianxun.admin.api.dto.sysDept.request.SysDeptSearchByIdDTO;
import com.qianxun.admin.api.entity.SysDept;
import org.apache.ibatis.annotations.Param;

/**
 * @author Cloudy
 * Date 2019-05-13 22:13:53
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {
   IPage getSysDeptsWithLang(Page page, @Param("inputDTO")SysDeptQueryInputDTO inputDTO);

   SysDeptDTO searchById(@Param("inputDTO")SysDeptSearchByIdDTO inputDTO);
}

