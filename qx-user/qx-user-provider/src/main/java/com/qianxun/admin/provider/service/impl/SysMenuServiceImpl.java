package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.admin.provider.mapper.SysMenuMapper;
import com.qianxun.admin.provider.service.SysMenuService;
import com.qianxun.admin.provider.service.SysRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Cloudy
 *  */
@Slf4j
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    private final SysRoleService sysRoleService;

    @Override
    public List<SysMenu> getMenusByRoleId(Integer roleId){
        return baseMapper.getMenusByRoleId(roleId);
    }

    @Override
    public List<SysMenu> getMenusByUserId(Integer userId){
        return baseMapper.getUserSpecialMenus(userId);
    }

    @Override
    public List<SysMenu> getUserMenus(Integer userId){
        //角色列表
        List<Integer> roleIds = sysRoleService.getRolesByUserId(userId)
                .stream()
                .map(SysRole::getId)
                .collect(Collectors.toList());

        //角色权限列表
        Set<SysMenu> menus = new HashSet<>();
        roleIds.forEach(roleId -> {
            menus.addAll(baseMapper.getMenusByRoleId(roleId));
        });
        //用户单独的权限列表
        menus.addAll(baseMapper.getUserSpecialMenus(userId));
        return menus.stream().filter(item -> item.getType() == 0)
                .sorted(Comparator.comparingInt(SysMenu::getSort))
                .collect(Collectors.toList());
    }
}

