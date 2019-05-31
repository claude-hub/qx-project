package com.qianxun.admin.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianxun.admin.api.entity.SysRole;

import java.util.List;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
   List<SysRole> getRolesByUserId(Integer id);
}

