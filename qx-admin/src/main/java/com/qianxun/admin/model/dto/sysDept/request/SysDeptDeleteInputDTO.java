package com.qianxun.admin.model.dto.sysDept.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class SysDeptDeleteInputDTO {
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}