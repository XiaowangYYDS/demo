package com.teng.author.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:xiaowang
 * @Data:2022/12/26/15:36 Description:
 */
@NoArgsConstructor
@AllArgsConstructor
public enum AppHttpCodeEnum {

    //成功
    SUCCESS(200,"操作成功"),
    ERROR(500,"出现错误"),
    SYSTEM_ERROR(500, "系统异常"),
    LOGIN_ERROR(505, "登录失败，请检查appId和appSecret"),
    NEED_LOGIN(506, "未登录"),
    NO_OPERATOR_AUTH(403,"无权限操作");

    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
