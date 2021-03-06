package com.tyler.service;

import com.tyler.error.BusinessException;
import com.tyler.service.model.UserModel;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/6
 * @ Time       :10:18 下午
 */
public interface UserService {

    UserModel getUserById(Integer id);
    void register(UserModel userModel) throws BusinessException;

    UserModel validateLogin(String telephone, String encrptPassword) throws BusinessException;
}
