package com.qianxun.admin.api.dto.sysDept.request;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Cloudy
 * @date 2019-05-13 00:37:19
 */
@Data
public class SysDeptAddInputDTO implements Serializable {
    @ApiModelProperty(value = "父类id")
    private Integer parentId;

    @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @NotBlank(message = "部门名称不能为空")
    @ApiModelProperty(value = "部门名称", required = true)
    private String name;

    @ApiModelProperty(value = "")

    private Integer sort;
}
