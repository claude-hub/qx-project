package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuQueryInputDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuSearchByIdDTO;
import com.qianxun.admin.api.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Cloudy
 *  */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
   IPage getSysMenusWithLang(Page page, @Param("inputDTO")SysMenuQueryInputDTO inputDTO);

   SysMenuDTO searchById(@Param("inputDTO")SysMenuSearchByIdDTO inputDTO);

   List<SysMenuDTO> getMenusByRoleId(Integer roleId);
}

