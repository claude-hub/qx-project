package com.qianxun.admin.api.dto.sysRole.response;

import com.qianxun.admin.api.entity.SysRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/5/9 20:59
 */

@Data
public class SysRoleResponseDTO  implements Serializable {
    /**
     * 总记录数
     */
    private Integer total;

    private List<SysRole> sysRole;
}
