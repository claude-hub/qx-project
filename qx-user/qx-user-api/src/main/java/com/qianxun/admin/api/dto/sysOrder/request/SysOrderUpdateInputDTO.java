package com.qianxun.admin.api.dto.sysOrder.request;

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
public class SysOrderUpdateInputDTO extends RequestDTO implements Serializable {
                                                                                            @NotNull(message = "序号不能为空")
                                    @ApiModelProperty(value = "序号", required = true)
                                    private Integer id;

                                                                                                    @NotBlank(message = "订单名不能为空")
                                    @ApiModelProperty(value = "订单名", required = true)
                                    private String name;

                                                                                                        @NotNull(message = "乐观锁版本不能为空")
            @ApiModelProperty(value = "乐观锁", required = true)
                    private Integer version;

            }
