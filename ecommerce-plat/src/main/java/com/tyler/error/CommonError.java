package com.tyler.error;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/7
 * @ Time       :11:03 下午
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
