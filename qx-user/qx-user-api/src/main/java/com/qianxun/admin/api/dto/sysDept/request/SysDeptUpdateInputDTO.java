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
 *  */
@Data
public class SysDeptUpdateInputDTO implements Serializable {
                                                                                            @NotNull(message = "主键不能为空")
                                    @ApiModelProperty(value = "主键ID", required = true)
                                    private Integer id;

                                                                            @ApiModelProperty(value = "")
                                    private Integer parentId;

                                                                            @ApiModelProperty(value = "")
                                    private Integer sort;

                                                                        @NotNull(message = "上此更新的时间不能为空")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @ApiModelProperty(value = "", required = true)
                    private Date updatedAt;

                                @NotNull(message = "语言Id不能为空")
    @ApiModelProperty(value = "语言id", required = true)
    private Integer langId;

    @ApiModelProperty(value = "SysDept名称")
    private String name;
}
