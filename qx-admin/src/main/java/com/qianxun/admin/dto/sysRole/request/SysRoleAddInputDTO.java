package com.qianxun.admin.dto.sysRole.request;

import java.util.Date;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * 
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */
public class SysRoleAddInputDTO {
                                                                                                                                                    @NotBlank(message = "角色名不能为空")
                        @ApiModelProperty(value = "角色名" , required = true)
                                            
                private String roleName;
                                                                                                                                                                        @NotBlank(message = "角色码不能为空")
                        @ApiModelProperty(value = "角色码" , required = true)
                                            
                private String roleCode;
                                                                                                                                            @ApiModelProperty(value = "角色描述")
                    
                private String roleDesc;
                                                                                                                                                                                                                                                                            @ApiModelProperty(value = "删除标识（0-正常,1-删除）")
                    
                private Integer status;
                                        
                                                                        public void setRoleName(String roleName) {
                        this.roleName = roleName;
                    }

                    public String getRoleName() {
                        return roleName;
                    }
                                                                                                public void setRoleCode(String roleCode) {
                        this.roleCode = roleCode;
                    }

                    public String getRoleCode() {
                        return roleCode;
                    }
                                                                                                public void setRoleDesc(String roleDesc) {
                        this.roleDesc = roleDesc;
                    }

                    public String getRoleDesc() {
                        return roleDesc;
                    }
                                                                                                                                                                                            public void setStatus(Integer status) {
                        this.status = status;
                    }

                    public Integer getStatus() {
                        return status;
                    }
                                        }