package com.example.demo.dao;

import com.example.demo.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-03-26 16:09
 */

@Mapper
public interface UserDao {
    UserModel findByNameAndPassword(@Param("name") String name , @Param ("password") String password);
}
