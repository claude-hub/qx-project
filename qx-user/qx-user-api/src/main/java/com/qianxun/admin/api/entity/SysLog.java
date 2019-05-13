package com.qianxun.admin.api.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cloudy
 * Date 2019-05-13 17:03:04
 */
@Data
public class SysLog implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 日志类型
     */
    private String type;
    /**
     * 日志标题
     */
    private String title;
    /**
     * 服务ID
     */
    private String serviceId;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    /**
     * 更新时间
     */
    @Version
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    /**
     * 操作IP地址
     */
    private String ipAddr;
    /**
     * 请求URI
     */
    private String requestUri;
    /**
     * 操作方式
     */
    private String method;
    /**
     * 操作提交的数据
     */
    private String params;
    /**
     * 执行时间
     */
    private Long time;
    /**
     * 异常信息
     */
    private String exception;
    /**
     * 1-正常，-1-删除
     */
    @TableLogic
    private Integer deleted;
}
