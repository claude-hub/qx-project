package com.qianxun.controller.basic;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.qianxun.config.AliyunSMSConfig;
import com.qianxun.controller.BaseController;
import com.qianxun.dto.QuerySMSInputDTO;
import com.qianxun.dto.SendSMSInputDTO;
import com.qianxun.utils.JSONResult;
import com.qianxun.utils.SMSUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 发送短信
 */
@RestController
public class UtilsController  extends BaseController {
    @Autowired
    AliyunSMSConfig aliyunSMSConfig;

    @ApiOperation(value = "发送短信", notes = "发送短信验证码", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
    @ApiOperation(value = "查询短信", notes = "获取短信详情", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
