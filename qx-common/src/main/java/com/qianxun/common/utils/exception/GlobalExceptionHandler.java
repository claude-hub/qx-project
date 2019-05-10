package com.qianxun.common.utils.exception;

import com.qianxun.common.utils.result.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全局异常处理类
 */
@Slf4j
@RestControllerAdvice
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
    public JSONResult handleException(Exception e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("system_error");
        jsonResult.setMessage(e.getMessage());
        log.error("全局异常信息 ex={}", e.getMessage(), e);
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
    public JSONResult handleBindException(BindException e) {
        List<Map<String, Object>> errorList = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            Map<String, Object> error = new HashMap<>();
            error.put("field", fieldError.getField());
            error.put("code", fieldError.getCode());
            error.put("message", fieldError.getDefaultMessage());
            errorList.add(error);
        }
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("validation_error");
        jsonResult.setMessage(errorList);
        log.error("验证数据的异常 ex={}", e.getMessage(), e);
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
    public JSONResult handleBusinessException(BusinessException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode(e.getErrorCode());
        jsonResult.setMessage(e.getMessage());
        log.error("所有业务异常 ex={}", e.getMessage(), e);
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
    public JSONResult handlePhoneServiceException(PhoneException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("phone_error");
        jsonResult.setMessage(e.getMessage());
        log.error("手机号错误异常 ex={}", e.getMessage(), e);
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
    public JSONResult handleInvalidServiceException(InvalidException e) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setErrCode("invalid_error");
        jsonResult.setMessage(e.getMessage());
        log.error("数据无效异常 ex={}", e.getMessage(), e);
        return jsonResult;
    }
}