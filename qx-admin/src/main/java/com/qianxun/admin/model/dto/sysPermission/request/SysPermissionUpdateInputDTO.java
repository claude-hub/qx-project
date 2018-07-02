package com.qianxun.admin.model.dto.sysPermission.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户权限表
 *
 * @author cloudy
 * @date 2018-06-12 22:49:20
 */
public class SysPermissionUpdateInputDTO {
    @NotNull(message = "不能为空")

    private Integer id;

    @NotBlank(message = "权限名不能为空")
    @ApiModelProperty(value = "权限名" , required = true)

    private String name;

    @NotNull(message = "模块枚举值不能为空")

    private Integer module;

    @ApiModelProperty(value = "描述")

    private String description;

    @NotBlank(message = "唯一标识不能为空")
    @ApiModelProperty(value = "唯一标识" , required = true)

    private String key;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public Integer getModule() {
        return module;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}