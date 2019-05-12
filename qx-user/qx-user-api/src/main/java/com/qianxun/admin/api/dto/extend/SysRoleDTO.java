package com.qianxun.admin.api.dto.extend;

import com.qianxun.admin.api.entity.SysRole;
import lombok.Data;

/**
 * @author Cloudy
 * Date: 2019/5/12 10:14
 */
@Data
public class SysRoleDTO extends SysRole {
    /**
     * 角色名
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
