package com.qianxun.dto.permission;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class AddPermissionFormInputDTO {
    /**
     * 权限名
     */
    @ApiModelProperty(value = "权限名",required = true)
    @NotBlank(message = "权限名不能为空")
    private String name;

    /**
     * 模块枚举值
     */
    @ApiModelProperty(value = "模块枚举值",required = true)
    @NotNull(message = "模块枚举值不能为空")
    private Integer module;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;

    /**
     * 唯一标识
     */
    @ApiModelProperty(value = "权限码",required = true)
    @NotBlank(message = "权限码不能为空")
    private String key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
