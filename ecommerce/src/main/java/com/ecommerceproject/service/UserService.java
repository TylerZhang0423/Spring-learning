package com.ecommerceproject.service;

import com.ecommerceproject.error.BusinessException;
import com.ecommerceproject.service.model.UserModel;

public interface UserService {
    UserModel getUserById (Integer id);
    void register(UserModel userModel) throws BusinessException;
}
