package com.teng.author.exception;

import com.teng.author.enums.AppHttpCodeEnum;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/19:15 Description:
 */

public class SystemException extends RuntimeException{

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    public SystemException(AppHttpCodeEnum appHttpCodeEnum){
        super(appHttpCodeEnum.getMsg());
        this.code = appHttpCodeEnum.getCode();
        this.msg = appHttpCodeEnum.getMsg();
    }
}
