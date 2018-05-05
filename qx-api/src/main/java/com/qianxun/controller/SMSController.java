package com.qianxun.controller;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.qianxun.config.AliyunSMSConfig;
import com.qianxun.dto.QuerySMSInputDTO;
import com.qianxun.dto.SendSMSInputDTO;
import com.qianxun.utils.JSONResult;
import com.qianxun.utils.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 发送短信
 */
@RestController
public class SMSController {
    @Autowired
    AliyunSMSConfig aliyunSMSConfig;

    @PostMapping("/sendSMS")
    public Boolean sendSms(SendSMSInputDTO sendSMSInputDTO) {
        try {
            SendSmsResponse response = SMSUtil.sendSms(sendSMSInputDTO.getPhoneNum(), aliyunSMSConfig);
            if (response.getCode() != null && response.getCode().equals("OK")) {
                return true;
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
    @GetMapping("/querySMS")
    public JSONResult querySendDetails(QuerySMSInputDTO querySMSInputDTO) {
        JSONResult<List<QuerySendDetailsResponse.SmsSendDetailDTO>> jsonResult = new JSONResult<>();
        try {
            QuerySendDetailsResponse query = SMSUtil.querySendDetails(querySMSInputDTO, aliyunSMSConfig);
            jsonResult.setData(query.getSmsSendDetailDTOs());

        } catch (ClientException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
}
