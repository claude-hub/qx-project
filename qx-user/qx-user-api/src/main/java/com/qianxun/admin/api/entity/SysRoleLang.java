package com.qianxun.admin.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Cloudy
 * Date: 2019/5/12 10:27
 */
@Data
public class SysRoleLang  implements Serializable {

    private Integer roleId;

    private Integer langId;

    private String name;

    private String roleDesc;
}
