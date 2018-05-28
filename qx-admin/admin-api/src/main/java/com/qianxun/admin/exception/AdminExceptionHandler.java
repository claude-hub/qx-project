package com.qianxun.admin.exception;

import com.qianxun.service.exception.AuthenticateException;
import com.qianxun.utils.result.JSONResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdminExceptionHandler {
    /**
     * 用户异常
     * @param e
     * @return
     */
    @ExceptionHandler(AuthenticateException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleUserNotFoundException(AuthenticateException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("USER_ERROR");
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }
}
