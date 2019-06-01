package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserQueryInputDTO;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.admin.api.entity.SysUser;
import com.qianxun.admin.provider.mapper.SysUserMapper;
import com.qianxun.admin.provider.service.SysMenuService;
import com.qianxun.admin.provider.service.SysRoleService;
import com.qianxun.admin.provider.service.SysUserService;
import com.qianxun.common.utils.jwt.JwtTokenUtil;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    @Override
    public IPage getUserWithRolePage(Page page, SysUserQueryInputDTO dto){
        return baseMapper.getUserVMsPage(page, dto);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public SysUserDTO getUserInfoByAccount(String account) {
        SysUserDTO sysUserDTO = new SysUserDTO();
        SysUser sysUser = getUserByAccount(account);
        BeanUtils.copyProperties(sysUser, sysUserDTO);
        return getUserPermissions(sysUserDTO);
    }

    @SneakyThrows
    @Override
    public SysUserDTO signIn(String loginStr, String password){
        SysUser user = getUserByAccount(loginStr);
        if (user == null) {
            return null;
        }
        if(!accountValid(user, password)){
            return null;
        }
        try {
            //验证token格式是否正确
            jwtTokenUtil.parseToken(user.getCurrentToken());
            //是否过期
            boolean flag = jwtTokenUtil.isTokenExpired(user.getCurrentToken());
            if (flag) {
                String token = jwtTokenUtil.generateToken(user.getId(), user.getPhone());
                user.setCurrentToken(token);
                baseMapper.updateById(user);
            }
        }catch (Exception e){
            String token = jwtTokenUtil.generateToken(user.getId(), user.getPhone());
            user.setCurrentToken(token);
            baseMapper.updateById(user);
        }
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(user, sysUserDTO);
        return getUserPermissions(sysUserDTO);
    }

    /**
     * 通过token登录
     * @param token 令牌
     * @return
     */
    @Override
    public SysUserDTO signIn(String token) {
        String userId = jwtTokenUtil.getPrivateClaimFromToken(token,"user_id");
        SysUser user = baseMapper.selectById(Integer.parseInt(userId));
        if (!user.getCurrentToken().equals(token)) {
            return null;
        }
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(user, sysUserDTO);
        return getUserPermissions(sysUserDTO);
    }

    /**
     * 通过账号获取用户
     * @param account
     * @return
     */
    @SneakyThrows
    private SysUser getUserByAccount(String account){
        return this.getOne(Wrappers.<SysUser>query().lambda()
                        .eq(SysUser::getPhone, account)
                        .or()
                        .eq(SysUser::getUserName, account)
                        .or()
                        .eq(SysUser::getEmail, account)
                , true);
    }

    private SysUserDTO getUserPermissions(SysUserDTO sysUserDTO){
        //角色列表
        List<Integer> roleIds = sysRoleService.getRolesByUserId(sysUserDTO.getId())
                .stream()
                .map(SysRole::getId)
                .collect(Collectors.toList());
        sysUserDTO.setRoles(roleIds);
        //角色权限列表
        Set<String> permissions = new HashSet<>();
        roleIds.forEach(roleId -> {
            List<String> rolePermissionList = sysMenuService.getMenusByRoleId(roleId)
                    .stream()
                    .filter(sysMenu -> StringUtils.isNotEmpty(sysMenu.getPermission()))
                    .map(SysMenu::getPermission)
                    .collect(Collectors.toList());
            permissions.addAll(rolePermissionList);
        });
        //用户单独的权限列表
        List<String> userPermissionList = sysMenuService.getMenusByUserId(sysUserDTO.getId())
                .stream()
                .filter(sysMenu -> StringUtils.isNotEmpty(sysMenu.getPermission()))
                .map(SysMenu::getPermission)
                .collect(Collectors.toList());
        permissions.addAll(userPermissionList);
        sysUserDTO.setPermissions(new ArrayList<>(permissions));
        return sysUserDTO;
    }

    /**
     * 密码验证
     * @param user
     * @param password
     * @return
     */
    private Boolean accountValid(SysUser user, String password) {
        return passwordEncoder.matches(password, user.getPasswordEncrypted());
    }
}
