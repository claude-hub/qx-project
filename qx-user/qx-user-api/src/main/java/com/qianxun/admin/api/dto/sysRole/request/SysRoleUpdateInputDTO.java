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
    private Integer id;

    @NotBlank(message = "角色码不能为空")
    @ApiModelProperty(value = "角色码", required = true)

    private String roleCode;

    @ApiModelProperty(value = "0: 正常，-1: 删除，默认0")
    private Integer status;

    @ApiModelProperty(value = "")
    private String dbSource;

}
