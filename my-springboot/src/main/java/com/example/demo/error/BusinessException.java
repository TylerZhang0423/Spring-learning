package com.example.demo.error;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-04-20 12:11
 */
public class BusinessException extends RuntimeException{

    public BusinessException(){}

    public BusinessException(String message) {
        super(message);
    }
}
