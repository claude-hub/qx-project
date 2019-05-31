package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianxun.admin.api.entity.SysMenu;

import java.util.List;

/**
 * @author Cloudy
 *  */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
   List<SysMenu> getMenusByRoleId(Integer roleId);

   List<SysMenu> getMenusByUserId(Integer userId);
}

