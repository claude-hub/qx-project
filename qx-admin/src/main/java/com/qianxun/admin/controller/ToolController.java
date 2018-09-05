package com.qianxun.admin.controller;

import com.qianxun.common.utils.captcha.CaptchaHelper;
import com.qianxun.common.utils.exception.InvalidException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/admin/tool")
public class ToolController {
    private CaptchaHelper captchaHelper = CaptchaHelper.getCaptchaHelper();

    @GetMapping("/captcha")
    public void captcha(@RequestParam String randomStr, HttpServletRequest request, HttpServletResponse response) throws InvalidException {
        if(StringUtils.isBlank(randomStr)){
            throw new InvalidException("机器码不能为空");
        }
        // 生成验证码
        captchaHelper.generate(request, response);
    }
    @GetMapping("/check-captcha")
    public void checkCaptcha(@RequestParam String captcha, HttpServletRequest request) throws CaptchaHelper.CaptchaException {
        // 验证码
        captchaHelper.validateThrow(request, captcha);
    }
}
