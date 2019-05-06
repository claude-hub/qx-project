package com.qianxun.admin.provider.model.dto.sysDept.request;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author cloudy
 * @date 2019-05-06 22:58:30
 */
@Data
public class SysDeptUpdateInputDTO implements Serializable {
    @NotNull(message = "不能为空")

    private Integer id;

    @NotNull(message = "不能为空")

    private Integer parentId;

    @ApiModelProperty(value = "")

    private Integer sort;


    @NotNull(message = "是否删除  -1：已删除  0：正常不能为空")

    private Integer status;

    @ApiModelProperty(value = "")

    private String dbSource;

}
