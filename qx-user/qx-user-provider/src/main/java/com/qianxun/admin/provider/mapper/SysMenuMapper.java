package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuQueryInputDTO;
import com.qianxun.admin.api.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

/**
 * @author cloudy
 * Date 2019-05-13 14:37:45
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
   IPage getSysMenusWithLang(Page page, @Param("inputDTO") SysMenuQueryInputDTO inputDTO);
}

