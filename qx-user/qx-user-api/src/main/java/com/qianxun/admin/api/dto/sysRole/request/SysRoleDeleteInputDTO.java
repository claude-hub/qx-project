package com.qianxun.admin.api.dto.sysRole.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serializable;

/**
 * 
 *
 * @author cloudy
 * @date 2019-05-10 09:27:45
 */
@Data
public class SysRoleDeleteInputDTO implements Serializable{
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
