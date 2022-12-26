package com.teng.author.handler.exception;

import com.teng.author.domin.ResponseResult;
import com.teng.author.enums.AppHttpCodeEnum;
import com.teng.author.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/19:17 Description:
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(Exception e){
        log.error("出现异常 + {}" + e);
        if (e instanceof SystemException){
            return ResponseResult.errorResult(((SystemException) e).getCode(),e.getMessage());
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(),e.getMessage());
        }
    }
}
