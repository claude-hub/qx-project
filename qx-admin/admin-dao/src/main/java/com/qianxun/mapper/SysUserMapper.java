package com.qianxun.mapper;

import com.qianxun.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SysUser record);

    /**
     * 验证列存在
     * @param columnName
     * @param value
     * @return
     */
    int columnStrExists(@Param("columnName") String columnName, @Param("value") String value);

    /**
     * 通过登录名(邮箱、用户名、手机号)获取用户
     * @param loginStr
     * @return
     */
    SysUser selectByLoginStr(@Param("loginStr") String loginStr);

    /**
     * 通过id，添加列
     * @param id
     * @param columnName
     * @param value
     * @return
     */
    int updateCol(@Param("id") Integer id, @Param("column") String columnName, @Param("value") Object value);

    /**
     * 更新登录次数
     * @param id
     */
    void increaseSignInCount(Integer id);

    /**
     * 更新登录时间
     * @param id
     */
    void updateSignInAt(Integer id);
}