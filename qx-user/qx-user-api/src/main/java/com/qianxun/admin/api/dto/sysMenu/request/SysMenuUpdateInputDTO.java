package com.qianxun.admin.api.dto.sysMenu.request;

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
public class SysMenuUpdateInputDTO extends RequestDTO implements Serializable {
                                                                                            @NotNull(message = "菜单ID不能为空")
                                    @ApiModelProperty(value = "菜单ID", required = true)
                                    private Integer id;

                                                                                                    @NotBlank(message = "菜单名不能为空")
                                    @ApiModelProperty(value = "菜单名", required = true)
                                    private String name;

                                                                            @ApiModelProperty(value = "父菜单ID")
                                    private Integer parentId;

                                                                                                    @NotBlank(message = "菜单权限标识不能为空")
                                    @ApiModelProperty(value = "菜单权限标识", required = true)
                                    private String permission;

                                                                            @ApiModelProperty(value = "VUE页面")
                                    private String component;

                                                                            @ApiModelProperty(value = "前端URL")
                                    private String path;

                                                                            @ApiModelProperty(value = "图标")
                                    private String icon;

                                                                            @ApiModelProperty(value = "排序值")
                                    private Integer sort;

                                                                            @ApiModelProperty(value = "菜单类型 （0菜单 1按钮）")
                                    private Integer type;

                                                                            @ApiModelProperty(value = "0-开启，1- 关闭")
                                    private Integer keepAlive;

                                                                        @NotNull(message = "上此更新的时间不能为空")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @ApiModelProperty(value = "更新时间", required = true)
                    private Date updatedAt;

                            }
