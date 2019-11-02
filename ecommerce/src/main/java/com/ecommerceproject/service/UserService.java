package com.ecommerceproject.service;

import com.ecommerceproject.error.BusinessException;
import com.ecommerceproject.service.model.UserModel;

public interface UserService {
    UserModel getUserById (Integer id);
    void register(UserModel userModel) throws BusinessException;


    //telephone 是用户手机，password是用户密码
    UserModel validateLogin(String telephone, String encrptPassword) throws BusinessException;
}
