package com.qianxun.admin.api.dto.sysDept.request;

import java.util.Date;
import lombok.Data;
import com.qianxun.admin.api.dto.base.RequestDTO;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Cloudy
 *  */
@Data
public class SysDeptAddInputDTO extends RequestDTO implements Serializable {
                                                                                                            @NotBlank(message = "部门名称不能为空")
                    @ApiModelProperty(value = "部门名称", required = true)
                                                private String name;

                                                                                        @ApiModelProperty(value = "")
                            private Integer parentId;

                                                                                        @ApiModelProperty(value = "")
                            private Integer sort;

                                                                                                                                                            }
