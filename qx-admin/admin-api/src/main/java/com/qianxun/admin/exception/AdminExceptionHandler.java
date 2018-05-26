package com.qianxun.admin.exception;

import com.qianxun.service.exception.UserNotFoundException;
import com.qianxun.utils.JSONResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AdminExceptionHandler {
    /**
     * 找不到用户
     *
     * @param e
     * @return
     */
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleUserNotFoundException(UserNotFoundException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("USER_NOT_FOUND");
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }
}
