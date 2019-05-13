package com.qianxun.admin.api.dto.sysRole.request;

import java.util.Date;
import lombok.Data;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author Cloudy
 * Date 2019-05-13 20:12:16
 */
@Data
public class SysRoleUpdateInputDTO implements Serializable {
    @NotNull(message = "主键不能为空")
    @ApiModelProperty(value = "主键ID", required = true)
    private Integer id;

    @ApiModelProperty(value = "角色码")
    private String roleCode;

    @NotNull(message = "上此更新的时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", required = true)
    private Date updatedAt;

    @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @ApiModelProperty(value = "SysRole名称")
    private String name;
}
