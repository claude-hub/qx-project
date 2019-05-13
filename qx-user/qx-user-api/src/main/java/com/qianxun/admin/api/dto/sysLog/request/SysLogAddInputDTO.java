package com.qianxun.admin.api.dto.sysLog.request;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author cloudy
 * Date 2019-05-13 17:03:04
 */
@Data
public class SysLogAddInputDTO implements Serializable {
    @ApiModelProperty(value = "日志类型")
    private String type;

    @ApiModelProperty(value = "日志标题")
    private String title;

    @ApiModelProperty(value = "服务ID")
    private String serviceId;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "操作IP地址")
    private String ipAddr;

    @ApiModelProperty(value = "请求URI")
    private String requestUri;

    @ApiModelProperty(value = "操作方式")
    private String method;

    @ApiModelProperty(value = "操作提交的数据")
    private String params;

    @ApiModelProperty(value = "执行时间")
    private Long time;

    @ApiModelProperty(value = "异常信息")
    private String exception;

}
