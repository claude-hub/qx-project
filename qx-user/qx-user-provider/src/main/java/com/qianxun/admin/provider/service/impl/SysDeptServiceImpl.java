package com.qianxun.admin.provider.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianxun.admin.api.dto.extend.SysDeptDTO;
import com.qianxun.admin.api.dto.sysDept.request.SysDeptQueryInputDTO;
import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.admin.api.entity.SysDeptLang;
import com.qianxun.admin.provider.mapper.SysDeptMapper;
import com.qianxun.admin.provider.service.SysDeptLangService;
import com.qianxun.admin.provider.service.SysDeptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Cloudy
 * Date 2019-05-13 00:37:19
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {
    private final SysDeptLangService sysDeptLangService;

    /**
     * 保存部门信息
     *
     * @param sysDeptDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean saveSysDept(SysDeptDTO sysDeptDTO) {
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(sysDeptDTO, sysDept);
        sysDept.setCreatedAt(new Date());
        baseMapper.insert(sysDept);
        SysDeptLang sysDeptLang = new SysDeptLang();
        BeanUtils.copyProperties(sysDeptDTO, sysDeptLang);
        sysDeptLang.setDeptId(sysDept.getId());
        return sysDeptLangService.save(sysDeptLang);
    }

    @Override
    public IPage getSysDepts(Page page, SysDeptQueryInputDTO inputDTO) {
        return baseMapper.getSysDeptsWithLang(page, inputDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateSysDept(SysDeptDTO sysDeptDTO) {
        if (sysDeptDTO.getUpdatedAt() == null){
            return false;
        }
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(sysDeptDTO, sysDept);
        if (baseMapper.updateById(sysDept) > 0) {
            sysDeptLangService.remove(Wrappers.<SysDeptLang>update().lambda()
                    .eq(SysDeptLang::getDeptId, sysDept.getId()));
            SysDeptLang sysDeptLang = new SysDeptLang();
            sysDeptLang.setDeptId(sysDeptDTO.getId());
            sysDeptLang.setLangId(sysDeptDTO.getLangId());
            sysDeptLang.setName(sysDeptDTO.getName());
            return sysDeptLangService.save(sysDeptLang);
        }
        return false;
    }
}

