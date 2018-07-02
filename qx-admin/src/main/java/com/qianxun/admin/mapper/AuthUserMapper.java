package com.qianxun.admin.mapper;

import com.qianxun.admin.model.dto.sysMenu.response.MenuTree;
import com.qianxun.admin.model.entity.SysMenu;
import com.qianxun.admin.model.entity.SysRole;
import com.qianxun.admin.model.entity.SysUser;
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
     * 通过用户id，获取用户动态菜单
     * @param id
     * @return
     */
    List<SysMenu> findMenusByUserId(Integer id);

    List<SysRole> findRolesByUserId(Integer id);

    List<MenuTree> selectUserMenuTree(Integer id);
}
