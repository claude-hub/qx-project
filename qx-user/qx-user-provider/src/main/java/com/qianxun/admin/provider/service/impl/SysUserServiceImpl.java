package com.qianxun.admin.provider.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.entity.SysUser;
import com.qianxun.admin.provider.mapper.SysUserMapper;
import com.qianxun.admin.provider.service.SysMenuService;
import com.qianxun.admin.provider.service.SysRoleService;
import com.qianxun.admin.provider.service.SysUserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Cloudy
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysRoleService sysRoleService;
    private final SysMenuService sysMenuService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysUserDTO getUserInfoByAccount(String account) {
        SysUserDTO sysRoleDTO = new SysUserDTO();
        SysUser sysUser = this.getOne(Wrappers.<SysUser>query().lambda()
                        .eq(SysUser::getPhone, account)
                        .or()
                        .eq(SysUser::getUserName, account)
                        .or()
                        .eq(SysUser::getEmail, account)
                , true);
        BeanUtils.copyProperties(sysUser, sysRoleDTO);
        //角色列表
        List<Integer> roleIds = sysRoleService.getRolesByUserId(sysUser.getId())
                .stream()
                .map(SysRoleDTO::getId)
                .collect(Collectors.toList());
        sysRoleDTO.setRoles(roleIds);
        //角色权限列表
        Set<String> permissions = new HashSet<>();
        roleIds.forEach(roleId -> {
            List<String> rolePermissionList = sysMenuService.getMenusByRoleId(roleId)
                    .stream()
                    .filter(sysMenuDTO -> StringUtils.isNotEmpty(sysMenuDTO.getMenuCode()))
                    .map(SysMenuDTO::getMenuCode)
                    .collect(Collectors.toList());
            permissions.addAll(rolePermissionList);
        });
        //用户单独的权限列表
        List<String> userPermissionList = sysMenuService.getMenusByUserId(sysUser.getId())
                .stream()
                .filter(sysMenuDTO -> StringUtils.isNotEmpty(sysMenuDTO.getMenuCode()))
                .map(SysMenuDTO::getMenuCode)
                .collect(Collectors.toList());
        permissions.addAll(userPermissionList);
        sysRoleDTO.setPermissions(new ArrayList<>(permissions));
        return sysRoleDTO;
    }
}
