package com.qianxun.admin.api.dto.sysMenu.request;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author cloudy
 * Date 2019-05-13 14:37:45
 */
@Data
public class SysMenuAddInputDTO implements Serializable {
    @ApiModelProperty(value = "父菜单ID")

    private Integer parentId;
    @NotBlank(message = "菜单权限标识不能为空")
    @ApiModelProperty(value = "菜单权限标识", required = true)

    private String menuCode;
    @ApiModelProperty(value = "前端URL")

    private String path;
    @ApiModelProperty(value = "图标")

    private String icon;
    @ApiModelProperty(value = "排序值")

    private Integer sort;
    @ApiModelProperty(value = "菜单类型 （0菜单 1按钮）")

    private Integer type;
    @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @NotBlank(message = "SysMenu名称不能为空")
    @ApiModelProperty(value = "SysMenu名称", required = true)
    private String name;
}
