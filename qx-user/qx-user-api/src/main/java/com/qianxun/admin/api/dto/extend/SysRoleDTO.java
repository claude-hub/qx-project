package com.qianxun.admin.api.dto.extend;

import com.qianxun.admin.api.entity.SysRole;
import lombok.Data;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
@Data
public class SysRoleDTO extends SysRole {
    /**
     * 国际化名称
     */
    private String name;

    /**
     * 语言Id
     */
    private Integer langId;

    /**
     * 角色描述
     */
    private String roleDesc;
}
