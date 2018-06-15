package com.qianxun.admin.dao;

import com.qianxun.admin.entity.SysPermission;
import com.qianxun.admin.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthUserMapper {
    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(Integer id);

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

    /**
     * 通过用户id，获取用户权限集合
     * @param id
     * @return
     */
    List<SysPermission> findPermissionsByUserId(Integer id);
}
