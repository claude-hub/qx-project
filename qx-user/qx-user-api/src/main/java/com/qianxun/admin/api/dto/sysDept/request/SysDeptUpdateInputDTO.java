package com.qianxun.admin.api.dto.sysDept.request;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import com.qianxun.admin.api.dto.base.RequestDTO;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Cloudy
 */
@Data
public class SysDeptUpdateInputDTO extends RequestDTO implements Serializable {
    @NotNull(message = "不能为空")
    @ApiModelProperty(value = "", required = true)
    private Integer id;

    @NotBlank(message = "部门名称不能为空")
    @ApiModelProperty(value = "部门名称", required = true)
    private String name;

    @ApiModelProperty(value = "")
    private Integer parentId;

    @ApiModelProperty(value = "")
    private Integer sort;

    /**
     * 乐观锁
     */
    @Version
    @ApiModelProperty(value = "乐观锁", required = true)
    @NotNull(message = "乐观锁版本不能为空")
    private Integer version;
}
