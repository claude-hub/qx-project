package com.qianxun.admin.api.dto.sysRole.request;

import lombok.Data;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author cloudy
 * @date 2019-05-10 09:27:45
 */
@Data
public class SysRoleUpdateInputDTO implements Serializable {
    @NotNull(message = "角色ID不能为空")
    @ApiModelProperty(value = "主键Id", required = true)
    private Integer id;

    @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @NotBlank(message = "角色名不能为空")
    @ApiModelProperty(value = "角色名", required = true)
    private String name;

    @NotBlank(message = "角色码不能为空")
    @ApiModelProperty(value = "角色码", required = true)
    private String roleCode;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;
}
