package com.qianxun.admin.api.dto.sysRole.request;

import lombok.Data;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
@Data
public class SysRoleAddInputDTO implements Serializable {
    @NotBlank(message = "角色码不能为空")
    @ApiModelProperty(value = "角色码", required = true)
    private String roleCode;

    @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @NotBlank(message = "SysRole名称不能为空")
    @ApiModelProperty(value = "SysRole名称", required = true)
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;
}
