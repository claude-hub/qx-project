package com.qianxun.admin.mapper;

import com.qianxun.admin.model.entity.SysRoleDept;

import java.util.List;

/**
 * 角色与部门对应关系
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */

 public interface SysRoleDeptMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleDept record);

    SysRoleDept selectByPrimaryKey(Integer id);

    List<SysRoleDept> selectAll();

    int updateByPrimaryKey(SysRoleDept record);

}