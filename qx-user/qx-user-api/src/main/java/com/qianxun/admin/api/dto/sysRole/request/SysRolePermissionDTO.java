package com.qianxun.admin.api.dto.sysRole.request;

import com.qianxun.admin.api.dto.base.RequestDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/6/3 1:51
 */
@Data
public class SysRolePermissionDTO extends RequestDTO implements Serializable {
    private List<Integer> menuIds;

    private Integer roleId;
}
