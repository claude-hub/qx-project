package com.qianxun.admin.api.dto.sysLang.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Cloudy
 * @date 2019-05-07 21:51:21
 */
@Data
public class SysLangAddInputDTO implements Serializable {
    @NotBlank(message = "语言名不能为空")
    @ApiModelProperty(value = "语言名", required = true)
    private String name;

    @NotBlank(message = "语言名不能为空")
    @ApiModelProperty(value = "语言Code", required = true)
    private String langCode;
}
