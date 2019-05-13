package com.qianxun.admin.api.dto.sysMenu.request;

import com.qianxun.admin.api.dto.base.SearchByIdInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @author Cloudy
 *  */
@Data
public class SysMenuSearchByIdDTO extends SearchByIdInputDTO {
    @NotNull(message = "语言ID不能为空")
    @ApiModelProperty(value = "语言ID", required = true)
    private Integer langId;
}
