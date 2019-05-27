package com.qianxun.admin.api.dto.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Cloudy
 * Date: 2019/5/28 0:27
 */
@Data
public class RequestDTO {
    @ApiModelProperty(value = "token")
    private String token;
}
