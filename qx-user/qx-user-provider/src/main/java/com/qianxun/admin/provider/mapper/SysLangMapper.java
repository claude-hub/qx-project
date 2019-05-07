package com.qianxun.admin.provider.mapper;

import com.qianxun.admin.api.entity.SysLang;
import java.util.List;

/**
 * @author cloudy
 * @date 2019-05-07 21:51:21
 */

public interface SysLangMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysLang record);

    SysLang selectByPrimaryKey(Integer id);

    List<SysLang> selectAll();

    int updateByPrimaryKey(SysLang record);

}
