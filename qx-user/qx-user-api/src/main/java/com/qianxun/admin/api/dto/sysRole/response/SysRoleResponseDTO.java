package com.qianxun.admin.api.dto.sysRole.response;

import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
@Data
public class SysRoleResponseDTO implements Serializable {
    /**
     * 总记录数
     * 需要加上默认为0，避免传回前端连字段都没有
     */
    private Integer total = 0;

    /**
     * 分页查询结果
     * 需初始化，避免传回前端无字段
     */
    private List<SysRoleDTO> sysRoles = new ArrayList<>();
}
