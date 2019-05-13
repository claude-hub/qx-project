package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleSearchByIdDTO;
import com.qianxun.admin.api.entity.SysRole;
import com.qianxun.admin.api.entity.SysRoleLang;
import com.qianxun.admin.provider.mapper.SysRoleMapper;
import com.qianxun.admin.provider.service.SysRoleLangService;
import com.qianxun.admin.provider.service.SysRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    private final SysRoleLangService sysRoleLangService;

    @Override
    public SysRoleDTO searchById(SysRoleSearchByIdDTO input){
        return baseMapper.searchById(input);
    }

    /**
     * 保存信息
     *
     * @param sysRoleDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveSysRole(SysRoleDTO sysRoleDTO) {
        SysRole sysRole = new SysRole();
        sysRole.setCreatedAt(new Date());
        BeanUtils.copyProperties(sysRoleDTO, sysRole);
        baseMapper.insert(sysRole);
        SysRoleLang sysRoleLang = new SysRoleLang();
        BeanUtils.copyProperties(sysRoleDTO, sysRoleLang);
        sysRoleLang.setRoleId(sysRole.getId());
        return sysRoleLangService.save(sysRoleLang);
    }

    @Override
    public IPage getSysRoles(Page page, SysRoleQueryInputDTO inputDTO) {
        return baseMapper.getSysRolesWithLang(page, inputDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateSysRole(SysRoleDTO sysRoleDTO) {
        if (sysRoleDTO.getUpdatedAt() == null){
            return false;
        }
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleDTO, sysRole);
        if (baseMapper.updateById(sysRole) > 0) {
            sysRoleLangService.remove(Wrappers.<SysRoleLang>update().lambda()
                    .eq(SysRoleLang::getRoleId, sysRole.getId()));
            SysRoleLang sysRoleLang = new SysRoleLang();
            sysRoleLang.setRoleId(sysRoleDTO.getId());
            sysRoleLang.setLangId(sysRoleDTO.getLangId());
            sysRoleLang.setName(sysRoleDTO.getName());
            return sysRoleLangService.save(sysRoleLang);
        }
        return false;
    }
}

