package com.qianxun.admin.provider.model.dto.sysDept.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serializable;

/**
 *
 *
 * @author cloudy
 * @date 2019-05-06 22:58:30
 */
@Data
public class SysDeptDeleteInputDTO implements Serializable{
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
