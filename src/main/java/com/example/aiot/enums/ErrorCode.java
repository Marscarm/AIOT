package com.example.aiot.enums;

import lombok.Getter;

/**
 * @author zichen.dang@sophgo.com
 */
@Getter
public enum ErrorCode {
    RESULT_SUCCESS(0, "请求成功"),
    BUSINESS_FAIL(1, "业务处理失败"),
    SYSTEM_ERROR(100001, "系统错误"),
    SERVICE_UNAVAILABLE(10002, "服务暂停"),
    REMOTE_SERVICE_ERROR(10003, "远程服务错误"),
    IP_LIMIT(10004, "IP限制不能请求该资源"),
    PERMISSION_DENIED(10005, "该资源需要拥有授权"),
    MISSING_REQUIRED_ARGUMENTS(10006, "缺少必选参数,请参考API文档"),
    INVALID_ARGUMENTS(10007, "非法的参数"),
    SYSTEM_BUSY(10008, "任务过多，系统繁忙"),
    RPC_ERROR(10009, "RPC错误"),
    ILLEGAL_REQUEST(10010, "非法请求"),
    INVALID_USER(10011, "不合法的用户"),
    MESSAGE_ERROR(10012, "消息处理异常"),
    REF_EXISTS(10013, "存在引用");

    private Integer code;
    private String msg;

    private ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsg(Integer code) {
        ErrorCode[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ErrorCode apiCodeEnum = var1[var3];
            if (code.equals(apiCodeEnum.getCode())) {
                return apiCodeEnum.getMsg();
            }
        }

        return BUSINESS_FAIL.getMsg();
    }
}
