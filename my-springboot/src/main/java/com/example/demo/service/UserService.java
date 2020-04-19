package com.example.demo.service;


import com.example.demo.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

//用户服务层接口
public interface UserService {
    UserModel findById(String id);
    List<UserModel> findAll();
    UserModel save(UserModel userModel);
    void delete(String id);

    Page<UserModel> findAll (Pageable pageable);


    List<UserModel> findByName (String name);
    List<UserModel> findByNameLike (String name);
    List<UserModel> findByIdIn (Collection<String> ids);

    UserModel findByNameAndPassword(String name, String password);


    Future<List<UserModel>> findAsynAll();

}
