package com.qianxun.admin.dto.sysUserRole.request;

import java.util.Date;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * 用户角色表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */
public class SysUserRoleAddInputDTO {
                                                                                                                                                    @NotNull(message = "角色ID不能为空")
                                            
                private Integer roleId;
                                        
                                                                        public void setRoleId(Integer roleId) {
                        this.roleId = roleId;
                    }

                    public Integer getRoleId() {
                        return roleId;
                    }
                                        }