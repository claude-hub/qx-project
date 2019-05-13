package com.qianxun.admin.api.dto.sysDept.request;

import java.util.Date;
import lombok.Data;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Cloudy
 * Date 2019-05-13 22:03:31
 */
@Data
public class SysDeptAddInputDTO implements Serializable {
                                                                                    @ApiModelProperty(value = "")
                            private Integer parentId;

                                                                                        @ApiModelProperty(value = "")
                            private Integer sort;

                                                                                                                                                                @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @NotBlank(message = "SysDept名称不能为空")
    @ApiModelProperty(value = "SysDept名称", required = true)
    private String name;
}
