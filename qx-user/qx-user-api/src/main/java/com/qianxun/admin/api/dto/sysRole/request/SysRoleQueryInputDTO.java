package com.qianxun.admin.api.dto.sysRole.request;

import com.qianxun.admin.api.dto.base.BaseQueryInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
@Data
public class SysRoleQueryInputDTO extends BaseQueryInputDTO implements Serializable {
    @NotNull(message = "语言ID不能为空")
    @ApiModelProperty(value = "语言ID", required = true)
    private Integer langId;
}
