package com.qianxun.admin.api.dto.sysDept.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cloudy
 * @date 2019-05-13 00:37:19
 */
@Data
public class SysDeptDeleteInputDTO implements Serializable {
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
