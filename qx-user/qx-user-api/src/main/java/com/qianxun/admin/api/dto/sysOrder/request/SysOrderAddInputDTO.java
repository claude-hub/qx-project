package com.qianxun.admin.api.dto.sysOrder.request;

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
public class SysOrderAddInputDTO extends RequestDTO implements Serializable {
                                                                                                            @NotBlank(message = "订单名不能为空")
                    @ApiModelProperty(value = "订单名", required = true)
                                                private String name;

                                                                                                                                                                                                        }
