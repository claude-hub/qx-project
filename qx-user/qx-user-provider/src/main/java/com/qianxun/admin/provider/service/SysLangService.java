package com.qianxun.admin.provider.service;

import com.qianxun.admin.api.entity.SysLang;
import java.util.List;

public interface SysLangService {
    boolean addSysLang(SysLang sysLang);

    boolean editSysLang(SysLang sysLang);

    List<SysLang> findAllSysLangs();

    SysLang getSysLang(int id);

    boolean deleteSysLang(int id);
}
