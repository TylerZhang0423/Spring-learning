package com.example.demo.error;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-04-20 12:30
 */
public class ErrorInfo<T> {

    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = 100;
    //错误码
    private Integer code;
    //错误信息
    private String message;
    private String url;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
