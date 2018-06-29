package com.qianxun.admin.dto.sysRoleMenu.request;

import java.util.Date;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * 角色菜单表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
public class SysRoleMenuAddInputDTO {
                                                                                                                                                    @NotNull(message = "菜单ID不能为空")
                                            
                private Integer menuId;
                                        
                                                                        public void setMenuId(Integer menuId) {
                        this.menuId = menuId;
                    }

                    public Integer getMenuId() {
                        return menuId;
                    }
                                        }