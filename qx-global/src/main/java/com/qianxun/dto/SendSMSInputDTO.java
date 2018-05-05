package com.qianxun.dto;

import io.swagger.annotations.ApiModelProperty;

public class SendSMSInputDTO {
    @ApiModelProperty(value = "手机号码" ,required = true)
    private String phoneNum;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
