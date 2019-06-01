package com.qianxun.admin.api.dto.sysUser.request;

import com.qianxun.admin.api.dto.base.BaseQueryInputDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Cloudy
 *  */
@Data
public class SysUserQueryInputDTO extends BaseQueryInputDTO implements Serializable{

    /**
     * 部门id
     */
    private Integer deptId;

}
