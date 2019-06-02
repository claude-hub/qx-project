package com.qianxun.admin.api.dto.sysRole.request;

import java.util.Date;

import lombok.Data;
import com.qianxun.admin.api.dto.base.RequestDTO;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Cloudy
 */
@Data
public class SysRoleUpdateInputDTO extends RequestDTO implements Serializable {
    @NotNull(message = "角色ID不能为空")
    @ApiModelProperty(value = "角色ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @NotBlank(message = "角色码不能为空")
    @ApiModelProperty(value = "角色码", required = true)
    private String roleCode;

    @NotNull(message = "乐观锁版本不能为空")
    @ApiModelProperty(value = "乐观锁版本", required = true)
    private Integer version;
}
