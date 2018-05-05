package com.qianxun.dto;

import io.swagger.annotations.ApiModelProperty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class QuerySMSInputDTO {

    /**
     * 可选-流水号
     */
    @ApiModelProperty(value = "流水号")
    private String bizId;
    /**
     * 必填-号码
     */
    @ApiModelProperty(value = "手机号码" ,required = true)
    private String phoneNum;
    /**
     * 必填-发送日期 支持30天内记录查询，格式yyyyMMdd
     */
    @ApiModelProperty(value = "发送日期-格式yyyyMMdd")
    private String sendDate = new SimpleDateFormat("yyyyMMdd",Locale.SIMPLIFIED_CHINESE).format(new Date());;
    /**
     * 必填-页大小
     */
    @ApiModelProperty(value = "页大小")
    private Long pageSize = 20L;
    /**
     * 必填-当前页码从1开始计数
     */
    @ApiModelProperty(value = "当前页码从1开始计数")
    private Long currentPage = 1L;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }
}
