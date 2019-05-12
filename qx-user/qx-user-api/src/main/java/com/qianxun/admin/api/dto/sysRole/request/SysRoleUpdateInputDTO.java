package com.qianxun.admin.api.dto.sysRole.request;

import lombok.Data;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * @author cloudy
 * @date 2019-05-10 09:27:45
 */
@Data
public class SysRoleUpdateInputDTO implements Serializable {
    @NotNull(message = "角色ID不能为空")
    @ApiModelProperty(value = "主键Id", required = true)
    private Integer id;

    @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @ApiModelProperty(value = "角色名")
    private String name;

    @ApiModelProperty(value = "角色码")
    private String roleCode;

    @ApiModelProperty(value = "角色描述")
    private String roleDesc;

    @ApiModelProperty(value = "上此更新的时间", required = true)
    @NotNull(message = "上此更新的时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
}
