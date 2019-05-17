package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.extend.SysMenuDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuQueryInputDTO;
import com.qianxun.admin.api.dto.sysMenu.request.SysMenuSearchByIdDTO;
import com.qianxun.admin.api.entity.SysMenu;
import com.qianxun.admin.api.entity.SysMenuLang;
import com.qianxun.admin.provider.mapper.SysMenuMapper;
import com.qianxun.admin.provider.service.SysMenuLangService;
import com.qianxun.admin.provider.service.SysMenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author Cloudy
 *  */
@Slf4j
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    private final SysMenuLangService sysMenuLangService;

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
}

