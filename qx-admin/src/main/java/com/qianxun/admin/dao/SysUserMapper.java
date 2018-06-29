package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */

public interface SysUserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    /**
     * 验证列存在
     *
     * @param columnName
     * @param value
     * @return
     */
    int columnStrExists(@Param("columnName") String columnName, @Param("value") String value);

}