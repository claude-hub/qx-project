package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.base.UpdateDBResponseDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRolePermissionDTO;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.admin.api.entity.SysRoleMenu;
import com.qianxun.admin.provider.mapper.SysRoleMapper;
import com.qianxun.admin.provider.service.SysRoleMenuService;
import com.qianxun.admin.provider.service.SysRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    private final SysRoleMenuService sysRoleMenuService;

    @Override
    public List<SysRole> getRolesByUserId(Integer userId){
        return baseMapper.getRolesByUserId(userId);
    }

    @Override
    @Transactional
    public UpdateDBResponseDTO addRolePerms(SysRolePermissionDTO dto){
        UpdateDBResponseDTO responseDTO = new UpdateDBResponseDTO();
        sysRoleMenuService.remove(Wrappers.<SysRoleMenu>update().lambda()
                    .eq(SysRoleMenu::getRoleId, dto.getRoleId()));
        if (dto.getMenuIds() != null) {
            dto.getMenuIds().forEach(menuId -> {
                SysRoleMenu roleMenu = new SysRoleMenu();
                roleMenu.setRoleId(dto.getRoleId());
                roleMenu.setMenuId(menuId);
                sysRoleMenuService.save(roleMenu);
            });
        }
        responseDTO.setSuccess(true);
        return responseDTO;
    }
}

