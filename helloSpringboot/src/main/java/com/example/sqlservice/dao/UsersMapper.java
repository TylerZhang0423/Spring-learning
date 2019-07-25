package com.example.sqlservice.dao;

import com.example.sqlservice.entity.Users;

public interface UsersMapper {
    int insert(Users record);

    int insertSelective(Users record);
}