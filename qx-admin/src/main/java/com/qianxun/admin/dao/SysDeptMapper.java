package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysDept;

import java.util.List;

/**
 * 部门管理
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */

 public interface SysDeptMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysDept record);

    SysDept selectByPrimaryKey(Integer id);

    List<SysDept> selectAll();

    int updateByPrimaryKey(SysDept record);

}