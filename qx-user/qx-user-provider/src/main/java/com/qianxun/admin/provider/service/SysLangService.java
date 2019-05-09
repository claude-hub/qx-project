package com.qianxun.admin.provider.service;

import com.qianxun.admin.api.entity.SysLang;
import java.util.List;

public interface SysLangService {
    int addSysLang(SysLang sysLang);

    int editSysLang(SysLang sysLang);

    List<SysLang> findAllSysLangs();

    SysLang getSysLang(int id);

    int deleteSysLang(int id);
}
