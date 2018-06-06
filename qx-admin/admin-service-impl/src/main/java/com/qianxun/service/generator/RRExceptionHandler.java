package com.qianxun.service.generator;

import com.qianxun.utils.result.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class RRExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

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
        logger.error(e.getMessage(), e);
        data.setMessage(e.getMessage());
        return data;
    }
}