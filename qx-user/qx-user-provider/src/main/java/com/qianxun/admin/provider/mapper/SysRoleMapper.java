package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleSearchByIdDTO;
import com.qianxun.admin.api.entity.SysRole;
import org.apache.ibatis.annotations.Param;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
   IPage getSysRolesWithLang(Page page, @Param("inputDTO") SysRoleQueryInputDTO inputDTO);

   SysRoleDTO searchById(@Param("inputDTO") SysRoleSearchByIdDTO inputDTO);
}

