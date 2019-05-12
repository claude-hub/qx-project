package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.admin.api.dto.sysRole.request.SysRoleQueryInputDTO;
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

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/10/19 9:32
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    private final SysRoleLangService roleLangService;

    /**
     * 保存角色信息
     * @param roleDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveRole(SysRoleDTO roleDTO){
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(roleDTO, sysRole);
        baseMapper.insert(sysRole);
        SysRoleLang roleLang = new SysRoleLang();
        BeanUtils.copyProperties(roleDTO, roleLang);
        roleLang.setRoleId(sysRole.getId());
        return roleLangService.save(roleLang);
    }

    @Override
    public IPage getRoles(Page page, SysRoleQueryInputDTO inputDTO){
        IPage a =baseMapper.getRolesWithLang(page, inputDTO);
        return a;
    }
}
