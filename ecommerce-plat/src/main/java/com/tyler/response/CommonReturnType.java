package com.tyler.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/7
 * @ Time       :10:53 下午
 */
@Getter
@Setter
public class CommonReturnType {
    private String status;
    private Object data;

    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }
}
