package com.qianxun.gateway;

/**
 * @author Cloudy
 * Date: 2019/5/18 12:17
 */
public class ValidateCaptchaException extends Exception {
    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCaptchaException() {
    }

    public ValidateCaptchaException(String msg) {
        super(msg);
    }
}
