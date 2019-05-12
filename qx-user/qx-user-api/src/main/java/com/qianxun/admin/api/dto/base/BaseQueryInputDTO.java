package com.qianxun.admin.api.dto.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * author: Claude
 * email: 314705487@qq.com
 * create date: 05/10/19 11:11
 */
@Data
public class BaseQueryInputDTO {
    @NotNull(message = "语言ID不能为空")
    @ApiModelProperty(value = "语言ID", required = true)
    private Integer langId;

    @ApiModelProperty(value = "搜索内容")
    private String query;

    @ApiModelProperty(value = "当前页,默认值=1", name = "page", dataType = "Integer")
    private Integer page = 1;

    @ApiModelProperty(value = "分页大小，默认值=5", name = "pageSize", dataType = "Integer")
    private Integer pageSize = 5;
}
