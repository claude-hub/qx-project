package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.admin.provider.mapper.SysMenuMapper;
import com.qianxun.admin.provider.service.SysMenuService;
import com.qianxun.admin.provider.service.SysRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author Cloudy
 *  */
@Slf4j
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    private final SysRoleService sysRoleService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<SysMenu> getMenusByRoleId(Integer roleId){
        return baseMapper.getMenusByRoleId(roleId);
    }

    @Override
    public List<SysMenu> getMenusByUserId(Integer userId){
        return baseMapper.getMenusByUserId(userId);
    }
}

