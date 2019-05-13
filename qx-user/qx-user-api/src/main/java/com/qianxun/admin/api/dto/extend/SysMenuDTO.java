package com.qianxun.admin.api.dto.extend;

import com.qianxun.admin.api.entity.SysMenu;
import lombok.Data;

/**
 * @author Cloudy
 * Date 2019-05-13 14:37:45
 */
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
