package com.qianxun.admin.provider.model.dto.sysDept.request;

import java.util.Date;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @author cloudy
 * @date 2019-04-27 14:07:32
 */
public class SysDeptUpdateInputDTO {
    @NotNull(message = "不能为空")

    private Integer id;

    @NotNull(message = "不能为空")

    private Integer parentId;

    @ApiModelProperty(value = "")

    private Integer sort;


    @NotNull(message = "是否删除  -1：已删除  0：正常不能为空")

    private Integer status;

    @ApiModelProperty(value = "")

    private String dbSource;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    public String getDbSource() {
        return dbSource;
    }
}
