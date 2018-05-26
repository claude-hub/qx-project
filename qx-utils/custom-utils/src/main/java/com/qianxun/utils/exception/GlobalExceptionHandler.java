package com.qianxun.utils.exception;

import com.qianxun.utils.JSONResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    JSONResult handleException(Exception e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("SYSTEM_ERROR");
        jsonResult.setMessage(e.getMessage());
        e.printStackTrace();
        return jsonResult;
    }

    /**
     * 处理BindException，验证数据的异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleBindException(BindException e) {
        List<Map<String, Object>> errorList = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            Map<String, Object> error = new HashMap<>();
            error.put("field", fieldError.getField());
            error.put("code", fieldError.getCode());
            error.put("message", fieldError.getDefaultMessage());
            errorList.add(error);
        }
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("VALIDATION_ERROR");
        jsonResult.setMessage(errorList);
        return jsonResult;
    }

    /**
     * 处理所有业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleBusinessException(BusinessException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode(e.getErrorCode());
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }

    /**
     * 手机错误异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(PhoneException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handlePhoneServiceException(PhoneException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("PHONE_ERROR");
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }
    /**
     * 数据无效异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(InvalidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleInvalidServiceException(InvalidException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("INVALID_ERROR");
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }
}