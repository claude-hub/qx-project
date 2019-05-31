package com.qianxun.admin.api.dto.sysUser.request;

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
public class SysUserAddInputDTO extends RequestDTO implements Serializable {
                                                                                    @ApiModelProperty(value = "部门ID")
                            private Integer deptId;

                                                                                        @ApiModelProperty(value = "姓名")
                            private String name;

                                                                                        @ApiModelProperty(value = "身份证")
                            private String identification;

                                                                                                                @NotBlank(message = "电话不能为空")
                    @ApiModelProperty(value = "电话", required = true)
                                                private String phone;

                                                                                        @ApiModelProperty(value = "邮箱")
                            private String email;

                                                                                        @ApiModelProperty(value = "头像")
                            private String avatar;

                                                                                        @ApiModelProperty(value = "0-正常，-1-冻结")
                            private Integer locked;

                                                                                                                                    @ApiModelProperty(value = "用户名")
                            private String userName;

                                                                                        @ApiModelProperty(value = "重置密码的token")
                            private String resetPasswordToken;

                                                                                                                @NotBlank(message = "加密后的密码不能为空")
                    @ApiModelProperty(value = "加密后的密码", required = true)
                                                private String passwordEncrypted;

                                                                                                                                                                                @ApiModelProperty(value = "当前的token")
                            private String currentToken;

                                                                                        @ApiModelProperty(value = "当前登录时间")
                            private Date currentSignInAt;

                                                                                        @ApiModelProperty(value = "上一次登录时间")
                            private Date lastSignInAt;

                                                                                        @ApiModelProperty(value = "累积登录次数")
                            private Integer signInCount;

                        }
