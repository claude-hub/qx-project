package com.qianxun.admin.api.dto.sysLang.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cloudy
 * @date 2019-05-07 21:51:21
 */
@Data
public class SysLangQueryInputDTO implements Serializable {
    @ApiModelProperty(value = "搜索内容")
    private String query;
    @ApiModelProperty(value = "当前页", name = "page", dataType = "Integer")
    private Integer page;
    @ApiModelProperty(value = "分页大小", name = "pageSize", dataType = "Integer")
    private Integer pageSize;
}
