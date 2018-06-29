package com.qianxun.admin.dto.sysUser.request;

import java.util.Date;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * 用户表
 *
 * @author cloudy
 * @date 2018-06-29 17:20:12
 */
public class SysUserUpdateInputDTO {
                                                                                            @NotNull(message = "主键ID不能为空")
                                    
            private Integer userId;
                    
                                                                    @ApiModelProperty(value = "部门ID")
                
            private Integer deptId;
                    
                                                                                            @NotBlank(message = "电话不能为空")
                    @ApiModelProperty(value = "电话" , required = true)
                                    
            private String phone;
                    
                                                                    @ApiModelProperty(value = "邮箱")
                
            private String email;
                    
                                                                    @ApiModelProperty(value = "头像")
                
            private String avatar;
                    
                                                                    @ApiModelProperty(value = "0-正常，-1-冻结")
                
            private Integer status;
                    
                                                                    @ApiModelProperty(value = "用户名")
                
            private String userName;
                    
                                                                    @ApiModelProperty(value = "重置密码的token")
                
            private String resetPasswordToken;
                    
                                                                                            @NotBlank(message = "加密后的密码不能为空")
                    @ApiModelProperty(value = "加密后的密码" , required = true)
                                    
            private String passwordEncrypted;
                    
                
                                            
                                                                    @ApiModelProperty(value = "当前的token")
                
            private String currentToken;
                    
                                                                    @ApiModelProperty(value = "当前登录时间")
                
            private Date currentSignInAt;
                    
                                                                    @ApiModelProperty(value = "上一次登录时间")
                
            private Date lastSignInAt;
                    
                                                                    @ApiModelProperty(value = "累积登录次数")
                
            private Integer signInCount;
                    
    
                                        public void setUserId(Integer userId) {
                    this.userId = userId;
                }

                public Integer getUserId() {
                    return userId;
                }
                                                            public void setDeptId(Integer deptId) {
                    this.deptId = deptId;
                }

                public Integer getDeptId() {
                    return deptId;
                }
                                                            public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getPhone() {
                    return phone;
                }
                                                            public void setEmail(String email) {
                    this.email = email;
                }

                public String getEmail() {
                    return email;
                }
                                                            public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getAvatar() {
                    return avatar;
                }
                                                            public void setStatus(Integer status) {
                    this.status = status;
                }

                public Integer getStatus() {
                    return status;
                }
                                                            public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getUserName() {
                    return userName;
                }
                                                            public void setResetPasswordToken(String resetPasswordToken) {
                    this.resetPasswordToken = resetPasswordToken;
                }

                public String getResetPasswordToken() {
                    return resetPasswordToken;
                }
                                                            public void setPasswordEncrypted(String passwordEncrypted) {
                    this.passwordEncrypted = passwordEncrypted;
                }

                public String getPasswordEncrypted() {
                    return passwordEncrypted;
                }
                                                                                                        public void setCurrentToken(String currentToken) {
                    this.currentToken = currentToken;
                }

                public String getCurrentToken() {
                    return currentToken;
                }
                                                            public void setCurrentSignInAt(Date currentSignInAt) {
                    this.currentSignInAt = currentSignInAt;
                }

                public Date getCurrentSignInAt() {
                    return currentSignInAt;
                }
                                                            public void setLastSignInAt(Date lastSignInAt) {
                    this.lastSignInAt = lastSignInAt;
                }

                public Date getLastSignInAt() {
                    return lastSignInAt;
                }
                                                            public void setSignInCount(Integer signInCount) {
                    this.signInCount = signInCount;
                }

                public Integer getSignInCount() {
                    return signInCount;
                }
                        }