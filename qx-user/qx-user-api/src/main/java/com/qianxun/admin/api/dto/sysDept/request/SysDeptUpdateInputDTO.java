package com.qianxun.admin.api.dto.sysDept.request;

import java.util.Date;
import lombok.Data;
import com.qianxun.admin.api.dto.base.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Cloudy
 *  */
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

                                                                        @NotNull(message = "上此更新的时间不能为空")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @ApiModelProperty(value = "", required = true)
                    private Date updatedAt;

                            }
