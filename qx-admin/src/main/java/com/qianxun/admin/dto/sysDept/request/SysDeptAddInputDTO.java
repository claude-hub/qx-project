package com.qianxun.admin.dto.sysDept.request;

import java.util.Date;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

/**
 * 部门管理
 *
 * @author cloudy
 * @date 2018-06-29 17:20:13
 */
public class SysDeptAddInputDTO {
                                                                                                                        @ApiModelProperty(value = "")
                    
                private Integer parentId;
                                                                                                                                                                        @NotBlank(message = "部门名称不能为空")
                        @ApiModelProperty(value = "部门名称" , required = true)
                                            
                private String name;
                                                                                                                                            @ApiModelProperty(value = "排序")
                    
                private Integer orderNum;
                                                                                                                                                                                                                                                                            @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
                    
                private Integer status;
                                        
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
                                                                                                public void setOrderNum(Integer orderNum) {
                        this.orderNum = orderNum;
                    }

                    public Integer getOrderNum() {
                        return orderNum;
                    }
                                                                                                                                                                                            public void setStatus(Integer status) {
                        this.status = status;
                    }

                    public Integer getStatus() {
                        return status;
                    }
                                        }