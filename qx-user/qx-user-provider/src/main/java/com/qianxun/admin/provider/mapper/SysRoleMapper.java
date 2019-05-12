package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
import com.qianxun.admin.api.entity.SysRole;
import org.apache.ibatis.annotations.Param;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/10/19 9:30
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    IPage getRolesWithLang(Page page, @Param("inputDTO")SysRoleQueryInputDTO inputDTO);
}
