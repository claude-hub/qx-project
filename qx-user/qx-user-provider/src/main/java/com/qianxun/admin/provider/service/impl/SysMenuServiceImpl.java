package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuQueryInputDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuSearchByIdDTO;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.admin.api.entity.SysMenuLang;
import com.qianxun.admin.provider.mapper.SysMenuMapper;
import com.qianxun.admin.provider.service.SysMenuLangService;
import com.qianxun.admin.provider.service.SysMenuService;
import com.qianxun.admin.provider.service.SysRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
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
    private final SysMenuLangService sysMenuLangService;
    private final SysRoleService sysRoleService;

    @Override
    public SysMenuDTO searchById(SysMenuSearchByIdDTO input){
        return baseMapper.searchById(input);
    }

    /**
     * 保存信息
     *
     * @param sysMenuDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveSysMenu(SysMenuDTO sysMenuDTO) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuDTO, sysMenu);
        sysMenu.setCreatedAt(new Date());
        baseMapper.insert(sysMenu);
        SysMenuLang sysMenuLang = new SysMenuLang();
        BeanUtils.copyProperties(sysMenuDTO, sysMenuLang);
        sysMenuLang.setMenuId(sysMenu.getId());
        return sysMenuLangService.save(sysMenuLang);
    }

    @Override
    public IPage getSysMenus(Page page, SysMenuQueryInputDTO inputDTO) {
        return baseMapper.getSysMenusWithLang(page, inputDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateSysMenu(SysMenuDTO sysMenuDTO) {
        if (sysMenuDTO.getUpdatedAt() == null){
            return false;
        }
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenuDTO, sysMenu);
        if (baseMapper.updateById(sysMenu) > 0) {
            sysMenuLangService.remove(Wrappers.<SysMenuLang>update().lambda()
                    .eq(SysMenuLang::getMenuId, sysMenu.getId()));
            SysMenuLang sysMenuLang = new SysMenuLang();
            sysMenuLang.setMenuId(sysMenuDTO.getId());
            sysMenuLang.setLangId(sysMenuDTO.getLangId());
            sysMenuLang.setName(sysMenuDTO.getName());
            return sysMenuLangService.save(sysMenuLang);
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<SysMenuDTO> getMenusByRoleId(Integer roleId){
        return baseMapper.getMenusByRoleId(roleId);
    }

    @Override
    public List<SysMenuDTO> getMenusByUserId(Integer userId){
        return baseMapper.getMenusByUserId(userId);
    }

    @Override
    public List<SysMenuDTO> getMenusWithLangByRoleId(Integer roleId, Integer langId){
        return baseMapper.getMenusWithLangByRoleId(roleId, langId);
    }

    @Override
    public List<SysMenuDTO> getUserMenusWithLang(Integer userId, Integer langId){
        //角色列表
        List<Integer> roleIds = sysRoleService.getRolesByUserId(userId)
                .stream()
                .map(SysRoleDTO::getId)
                .collect(Collectors.toList());

        //角色权限列表
        Set<SysMenuDTO> menus = new HashSet<>();
        roleIds.forEach(roleId -> {
            menus.addAll(baseMapper.getMenusWithLangByRoleId(roleId, langId));
        });
        //用户单独的权限列表
        menus.addAll(baseMapper.getMenusWithLangByUserId(userId, langId));
        return new ArrayList<>(menus);
    }
}

