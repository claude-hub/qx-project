package com.qianxun.generator.utils.exception;

import com.qianxun.common.utils.result.JSONResult;
import com.qianxun.generator.utils.exception.RRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class RRExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RRException.class)
    public JSONResult handleRRException(RRException e){
        JSONResult data = new JSONResult();
        data.setErrCode(e.getCode());
        data.setMessage(e.getMessage());
        return data;
    }

    @ExceptionHandler(Exception.class)
    public JSONResult handleException(Exception e){
        JSONResult data = new JSONResult();
        data.setMessage(e.getMessage());
        return data;
    }
}