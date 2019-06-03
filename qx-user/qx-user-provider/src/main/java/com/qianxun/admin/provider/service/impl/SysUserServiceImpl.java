package com.qianxun.admin.provider.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.extend.SysUserDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserAddInputDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserQueryInputDTO;
import com.qianxun.admin.api.dto.sysUser.request.SysUserUpdateInputDTO;
import com.qianxun.admin.api.entity.*;
import com.qianxun.admin.provider.mapper.SysUserMapper;
import com.qianxun.admin.provider.service.*;
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

    private final SysUserRoleService sysUserRoleService;
    private final SysUserMenuService sysUserMenuService;
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

    @Override
    @SneakyThrows
    @Transactional
    public UpdateDBResponseDTO addUser(SysUserAddInputDTO addInputDTO){
        UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(addInputDTO, sysUser);
        sysUser.setPasswordEncrypted(passwordEncoder.encode(sysUser.getPasswordEncrypted()));
        if (this.getOne(Wrappers.<SysUser>query().lambda()
                .eq(SysUser::getPhone, addInputDTO.getPhone())) != null) {
            responseDTO.setSuccess(false);
            responseDTO.setMessage("手机号已存在");
        } else {
            if (this.getOne(Wrappers.<SysUser>query().lambda()
                    .eq(SysUser::getUserName, addInputDTO.getUserName())) != null) {
                responseDTO.setSuccess(false);
                responseDTO.setMessage("用户名已存在");
            } else {
                if (this.getOne(Wrappers.<SysUser>query().lambda()
                        .eq(SysUser::getEmail, addInputDTO.getEmail())) != null) {
                    responseDTO.setSuccess(false);
                    responseDTO.setMessage("邮箱已存在");
                } else {
                    this.save(sysUser);
                    List<SysUserRole> roles = new ArrayList<>();
                    for (Integer roleId :
                            addInputDTO.getRoleIds()) {
                        SysUserRole role = new SysUserRole();
                        role.setUserId(sysUser.getId());
                        role.setRoleId(roleId);
                        roles.add(role);
                    }
                    sysUserRoleService.saveBatch(roles);
                    if (addInputDTO.getPermissionIds() != null) {
                        List<SysUserMenu> menus = new ArrayList<>();
                        for (Integer menuId :
                                addInputDTO.getPermissionIds()) {
                            SysUserMenu sysUserMenu = new SysUserMenu();
                            sysUserMenu.setMenuId(menuId);
                            sysUserMenu.setUserId(sysUser.getId());
                            menus.add(sysUserMenu);
                        }
                        sysUserMenuService.saveBatch(menus);
                    }
                    responseDTO.setSuccess(true);
                }
            }
        }
        return responseDTO;
    }

    @Override
    public UpdateDBResponseDTO updateUser(SysUserUpdateInputDTO dto){
        UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(dto, sysUser);
        if (sysUser.getPasswordEncrypted() != null) {
            sysUser.setPasswordEncrypted(passwordEncoder.encode(sysUser.getPasswordEncrypted()));
        }
        if(this.updateById(sysUser)){
            /**
             * 保存角色
             */
            sysUserRoleService.remove(Wrappers.<SysUserRole>update().lambda()
                    .eq(SysUserRole::getUserId, dto.getId()));
            dto.getRoleIds().forEach(roleId -> {
                SysUserRole userRole = new SysUserRole();
                userRole.setUserId(sysUser.getId());
                userRole.setRoleId(roleId);
                sysUserRoleService.save(userRole);
            });

            /**
             * 单独权限
             */
            sysUserMenuService.remove(Wrappers.<SysUserMenu>update().lambda()
                    .eq(SysUserMenu::getUserId, dto.getId()));
            if (dto.getPermissionIds() != null && dto.getPermissionIds().size() > 0) {
                dto.getPermissionIds().forEach(menuId -> {
                    SysUserMenu userMenu = new SysUserMenu();
                    userMenu.setUserId(sysUser.getId());
                    userMenu.setMenuId(menuId);
                    sysUserMenuService.save(userMenu);
                });
            }
            responseDTO.setSuccess(true);
        }else {
            responseDTO.setSuccess(false);
            responseDTO.setMessage("其他人已更新，更新失败!");
        }
        return responseDTO;
    }
}
