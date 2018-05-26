package com.qianxun.mapper;

import com.qianxun.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysUser record);

    int columnStrExists(@Param("columnName") String columnName, @Param("value") String value);

    SysUser selectByLoginStr(@Param("loginStr") String loginStr);
}