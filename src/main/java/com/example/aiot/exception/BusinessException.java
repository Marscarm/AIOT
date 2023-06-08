package com.example.aiot.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常
 *
 * @author ju.wang@sophgo.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {

    private Integer code = -1;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        this(message);
        this.code = code;
    }
}
