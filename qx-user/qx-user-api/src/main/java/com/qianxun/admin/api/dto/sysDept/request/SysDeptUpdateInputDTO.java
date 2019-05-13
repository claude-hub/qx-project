package com.qianxun.admin.api.dto.sysDept.request;

import java.util.Date;
import lombok.Data;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Cloudy
 * @date 2019-05-13 00:37:19
 */
@Data
public class SysDeptUpdateInputDTO implements Serializable {
    @NotNull(message = "不能为空")
    private Integer id;
    private Integer parentId;
    @ApiModelProperty(value = "")
    private Integer sort;
    @NotNull(message = "上此更新的时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "", required = true)
    private Date updatedAt;
    @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
    private Integer deleted;

    @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @NotBlank(message = "SysDept名称不能为空")
    @ApiModelProperty(value = "SysDept名称", required = true)
    private String name;
}
