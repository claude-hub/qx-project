package com.qianxun.admin.api.dto.extend;

import com.qianxun.admin.api.entity.SysMenu;
import lombok.Data;

/**
 * @author Cloudy
 *  */
@Data
public class SysMenuDTO extends SysMenu {
    /**
     * 国际化名称
     */
    private String name;

    /**
     * 语言Id
     */
    private Integer langId;
}
