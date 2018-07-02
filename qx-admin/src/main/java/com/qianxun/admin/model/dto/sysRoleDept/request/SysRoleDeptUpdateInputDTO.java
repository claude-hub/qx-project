package com.qianxun.admin.model.dto.sysRoleDept.request;

import java.util.Date;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * 角色与部门对应关系
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
public class SysRoleDeptUpdateInputDTO {
                                                                                            @NotNull(message = "角色ID不能为空")
                                    
            private Integer roleId;
                    
                                                                                            @NotNull(message = "部门ID不能为空")
                                    
            private Integer deptId;
                    
    
                                        public void setRoleId(Integer roleId) {
                    this.roleId = roleId;
                }

                public Integer getRoleId() {
                    return roleId;
                }
                                                            public void setDeptId(Integer deptId) {
                    this.deptId = deptId;
                }

                public Integer getDeptId() {
                    return deptId;
                }
                        }