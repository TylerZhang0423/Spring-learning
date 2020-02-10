package com.example.demo.repository;


import com.example.demo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<UserModel,String> {

    //自定义通过名字查询
    List<UserModel> findByName (String name);

    //自定义通过名字like查询
    List<UserModel> findByNameLike (String name);

    //自定义通过主键集合查询
    List<UserModel> findByIdIn (Collection<String> ids);

}

