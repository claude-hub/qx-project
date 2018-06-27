package com.qianxun.admin.controller;

import com.qianxun.common.utils.captcha.CaptchaHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "api/tool")
public class ToolController {
    private CaptchaHelper captchaHelper = CaptchaHelper.getCaptchaHelper();

    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        // 生成验证码
        captchaHelper.generate(request, response);
    }
}
