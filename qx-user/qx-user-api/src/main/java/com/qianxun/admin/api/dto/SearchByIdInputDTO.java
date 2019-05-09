package com.qianxun.admin.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/09/19 9:48
 */
@Data
public class SearchByIdInputDTO implements Serializable {
    @NotNull(message = "主键ID不能为空")
    @ApiModelProperty(value = "主键ID", required = true)
    private Integer id;
}
