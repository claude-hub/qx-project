package com.qianxun.admin.api.dto.sysLang.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author cloudy
 * @date 2019-05-07 21:51:21
 */
@Data
public class SysLangDeleteInputDTO implements Serializable {
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
