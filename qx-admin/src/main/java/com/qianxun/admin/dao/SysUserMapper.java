package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysUser;

import java.util.List;

/**
 * 用户表
 *
 * @author cloudy
 * @date 2018-06-08 12:04:33
 */

public interface SysUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

}