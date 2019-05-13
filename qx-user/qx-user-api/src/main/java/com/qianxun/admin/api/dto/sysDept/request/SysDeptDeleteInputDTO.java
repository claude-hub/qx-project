package com.qianxun.admin.api.dto.sysDept.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serializable;

/**
 * @author Cloudy
 * Date 2019-05-13 22:03:31
 */
@Data
public class SysDeptDeleteInputDTO implements Serializable{
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
