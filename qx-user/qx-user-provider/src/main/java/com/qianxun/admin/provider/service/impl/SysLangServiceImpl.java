package com.qianxun.admin.provider.service.impl;

import com.qianxun.admin.provider.mapper.SysLangMapper;
import com.qianxun.admin.api.entity.SysLang;
import com.qianxun.admin.provider.service.SysLangService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class SysLangServiceImpl implements SysLangService {
    private final SysLangMapper sysLangMapper;

    @Override
    public boolean addSysLang(SysLang sysLang) {
        return this.sysLangMapper.insert(sysLang) > 0;
    }

    @Override
    public boolean editSysLang(SysLang sysLang) {
        return sysLangMapper.updateByPrimaryKey(sysLang) > 0;

    }

    @Override
    public List<SysLang> findAllSysLangs() {
        return sysLangMapper.selectAll();
    }

    @Override
    public SysLang getSysLang(int id) {
        return sysLangMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteSysLang(int id) {
        return sysLangMapper.deleteByPrimaryKey(id) > 0;
    }
}
