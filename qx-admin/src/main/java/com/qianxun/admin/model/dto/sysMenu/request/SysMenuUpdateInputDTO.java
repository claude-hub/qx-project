package com.qianxun.admin.model.dto.sysMenu.request;

import java.util.Date;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * 菜单权限表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */
public class SysMenuUpdateInputDTO {
                                                                                            @NotNull(message = "菜单ID不能为空")
                                    
            private Integer menuId;
                    
                                                                    @ApiModelProperty(value = "父菜单ID")
                
            private Integer parentId;
                    
                                                                                            @NotBlank(message = "菜单名称不能为空")
                    @ApiModelProperty(value = "菜单名称" , required = true)
                                    
            private String name;
                    
                                                                                            @NotBlank(message = "菜单权限标识不能为空")
                    @ApiModelProperty(value = "菜单权限标识" , required = true)
                                    
            private String menuCode;
                    
                                                                    @ApiModelProperty(value = "请求链接")
                
            private String url;
                    
                                                                    @ApiModelProperty(value = "图标")
                
            private String icon;
                    
                                                                    @ApiModelProperty(value = "排序值")
                
            private Integer sort;
                    
                                                                    @ApiModelProperty(value = "菜单类型 （0菜单 1按钮）")
                
            private Integer type;
                    
                
                                            
                                                                    @ApiModelProperty(value = "0--正常 1--删除")
                
            private Integer status;
                    
    
                                        public void setMenuId(Integer menuId) {
                    this.menuId = menuId;
                }

                public Integer getMenuId() {
                    return menuId;
                }
                                                            public void setParentId(Integer parentId) {
                    this.parentId = parentId;
                }

                public Integer getParentId() {
                    return parentId;
                }
                                                            public void setName(String name) {
                    this.name = name;
                }

                public String getName() {
                    return name;
                }
                                                            public void setMenuCode(String menuCode) {
                    this.menuCode = menuCode;
                }

                public String getMenuCode() {
                    return menuCode;
                }
                                                            public void setUrl(String url) {
                    this.url = url;
                }

                public String getUrl() {
                    return url;
                }
                                                            public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getIcon() {
                    return icon;
                }
                                                            public void setSort(Integer sort) {
                    this.sort = sort;
                }

                public Integer getSort() {
                    return sort;
                }
                                                            public void setType(Integer type) {
                    this.type = type;
                }

                public Integer getType() {
                    return type;
                }
                                                                                                        public void setStatus(Integer status) {
                    this.status = status;
                }

                public Integer getStatus() {
                    return status;
                }
                        }