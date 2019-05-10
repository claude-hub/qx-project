package com.qianxun.admin.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/10/19 11:11
 */
@Data
public class BaseQueryInputDTO {
    @ApiModelProperty(value = "搜索内容")
    private String query;
    @ApiModelProperty(value = "当前页", name = "page", dataType = "Integer")
    private Integer page = 1;
    @ApiModelProperty(value = "分页大小", name = "pageSize", dataType = "Integer")
    private Integer pageSize = 5;
}
