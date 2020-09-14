package com.tyler.service.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/6
 * @ Time       :10:21 下午
 */
@Getter
@Setter
@ToString
public class UserModel {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String telephone;
    private String registerMode;
    private String thirdPartyId;
    private String encrptPassword;
}
