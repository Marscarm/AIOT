package com.example.aiot.vo;

import com.example.aiot.enums.ErrorCode;

/**
 * @author zichen.dang@sophgo.com
 */
public class Result<T> {


    private Integer code;
    private String msg;
    private T result;

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

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Result() {
    }

    public Result<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public Result<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> result(T result) {
        this.result = result;
        return this;
    }


    public static Result ok() {
        return (new Result()).code(ErrorCode.RESULT_SUCCESS.getCode()).msg(ErrorCode.RESULT_SUCCESS.getMsg());
    }

    public static <T> Result<T> ok(T result) {
        return (new Result()).code(ErrorCode.RESULT_SUCCESS.getCode()).msg(ErrorCode.RESULT_SUCCESS.getMsg()).result(result);
    }

    public static <T> Result<T> error(Integer code, String message) {
        Result<T> msg = new Result();
        msg.msg = message;
        msg.code = code;
        return msg;
    }

    public static <T> Result<T> error(Integer code) {
        return error(code, ErrorCode.getMsg(code));
    }

    public static <T> Result<T> errorResult(T result) {
        return (new Result()).result(result).code(ErrorCode.BUSINESS_FAIL.getCode()).msg(ErrorCode.BUSINESS_FAIL.getMsg());
    }

    public static <T> Result<T> error() {
        return error(ErrorCode.BUSINESS_FAIL.getCode(), ErrorCode.BUSINESS_FAIL.getMsg());
    }

    public static <T> Result<T> error(String message) {
        return error(ErrorCode.BUSINESS_FAIL.getCode(), message);
    }

    public static <T> Result<T> errorResultWithMsg(Integer code, String message, T result) {
        return (new Result()).result(result).code(code).msg(message);
    }


}
