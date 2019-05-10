package com.qianxun.admin.api.dto.sysLang.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author cloudy
 * @date 2019-05-07 21:51:21
 */
@Data
public class SysLangUpdateInputDTO implements Serializable {
    @NotNull(message = "主键ID不能为空")

    private Integer id;

    @NotBlank(message = "语言名不能为空")
    @ApiModelProperty(value = "语言名", required = true)
    private String name;

    @ApiModelProperty(value = "0: 正常，-1: 删除，默认0")
    private Integer status;

    @ApiModelProperty(value = "")
    private String dbSource;

}
