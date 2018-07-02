package com.qianxun.admin.model.dto.sysRoleMenu.request;

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
public class SysRoleMenuUpdateInputDTO {
                                                                                            @NotNull(message = "角色ID不能为空")
                                    
            private Integer roleId;
                    
                                                                                            @NotNull(message = "菜单ID不能为空")
                                    
            private Integer menuId;
                    
    
                                        public void setRoleId(Integer roleId) {
                    this.roleId = roleId;
                }

                public Integer getRoleId() {
                    return roleId;
                }
                                                            public void setMenuId(Integer menuId) {
                    this.menuId = menuId;
                }

                public Integer getMenuId() {
                    return menuId;
                }
                        }