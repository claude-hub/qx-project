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
    public int addSysLang(SysLang sysLang) {
        return this.sysLangMapper.insert(sysLang);
    }

    @Override
    public int editSysLang(SysLang sysLang) {
        return sysLangMapper.updateByPrimaryKey(sysLang);

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
    public int deleteSysLang(int id) {
        return sysLangMapper.deleteByPrimaryKey(id);
    }
}
