package com.qianxun.admin.api.dto.sysRole.request;

import java.util.Date;

import lombok.Data;
import com.qianxun.admin.api.dto.base.RequestDTO;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Cloudy
 */
@Data
public class SysRoleAddInputDTO extends RequestDTO implements Serializable {
    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @NotBlank(message = "角色码不能为空")
    @ApiModelProperty(value = "角色码", required = true)
    private String roleCode;

}
