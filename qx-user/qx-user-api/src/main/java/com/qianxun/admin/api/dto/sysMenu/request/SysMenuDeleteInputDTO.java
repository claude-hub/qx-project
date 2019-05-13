package com.qianxun.admin.api.dto.sysMenu.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serializable;

/**
 * @author cloudy
 * Date 2019-05-13 14:37:45
 */
@Data
public class SysMenuDeleteInputDTO implements Serializable{
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
