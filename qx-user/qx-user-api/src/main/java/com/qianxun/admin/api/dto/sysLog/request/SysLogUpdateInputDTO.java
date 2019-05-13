package com.qianxun.admin.api.dto.sysLog.request;

import java.util.Date;

import lombok.Data;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author cloudy
 * Date 2019-05-13 15:37:01
 */
@Data
public class SysLogUpdateInputDTO implements Serializable {
    @NotNull(message = "不能为空")
    @ApiModelProperty(value = "", required = true)
    private Long id;

    @ApiModelProperty(value = "日志类型")
    private String type;

    @ApiModelProperty(value = "日志标题")
    private String title;

    @ApiModelProperty(value = "服务ID")
    private String serviceId;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @NotNull(message = "上此更新的时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间", required = true)
    private Date updatedAt;

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
