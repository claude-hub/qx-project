package com.qianxun.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.qianxun.config.AliyunSMSConfig;
import com.qianxun.dto.QuerySMSInputDTO;

/**
 * 短信工具类
 */
public class SMSUtil {
    //产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    public static SendSmsResponse sendSms(String phoneNum, AliyunSMSConfig aliyunSMSConfig) throws ClientException {

        String accessKeyId = aliyunSMSConfig.getAccessKeyId();
        String accessKeySecret = aliyunSMSConfig.getAccessKeySecret();

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "1000");
        System.setProperty("sun.net.client.defaultReadTimeout", "1000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phoneNum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(aliyunSMSConfig.getSignName());
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(aliyunSMSConfig.getTemplateCode());

        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam("{\"code\":\"" + verifyCode + "\"}");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId(verifyCode);

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

    public static QuerySendDetailsResponse querySendDetails(QuerySMSInputDTO querySMSInputDTO, AliyunSMSConfig aliyunSMSConfig) throws ClientException {
        String accessKeyId = aliyunSMSConfig.getAccessKeyId();
        String accessKeySecret = aliyunSMSConfig.getAccessKeySecret();

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "1000");
        System.setProperty("sun.net.client.defaultReadTimeout", "1000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(querySMSInputDTO.getPhoneNum());
        //可选-流水号
        request.setBizId(querySMSInputDTO.getBizId());
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        request.setSendDate(querySMSInputDTO.getSendDate());
        //必填-页大小
        request.setPageSize(querySMSInputDTO.getPageSize());
        //必填-当前页码从1开始计数
        request.setCurrentPage(querySMSInputDTO.getCurrentPage());

        //hint 此处可能会抛出异常，注意catch
        QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);

        return querySendDetailsResponse;
    }
}