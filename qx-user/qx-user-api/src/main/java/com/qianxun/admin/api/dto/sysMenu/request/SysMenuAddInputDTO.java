package com.qianxun.admin.api.dto.sysMenu.request;

import java.util.Date;

import lombok.Data;
import com.qianxun.admin.api.dto.base.RequestDTO;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Cloudy
 */
@Data
public class SysMenuAddInputDTO extends RequestDTO implements Serializable {
    @NotBlank(message = "菜单名不能为空")
    @ApiModelProperty(value = "菜单名", required = true)
    private String name;

    @ApiModelProperty(value = "父菜单ID")
    private Integer parentId;

    @ApiModelProperty(value = "菜单权限标识")
    private String permission;

    @ApiModelProperty(value = "VUE页面")
    private String component;

    @ApiModelProperty(value = "前端URL")
    private String path;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @ApiModelProperty(value = "菜单类型 （0菜单 1按钮）")
    private Integer type;

    @ApiModelProperty(value = "0-开启，1- 关闭")
    private Integer keepAlive;

}
