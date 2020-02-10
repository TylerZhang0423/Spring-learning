package com.example.demo.service.impl;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

//用户服务层实现类
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Override
    public UserModel findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public UserModel save(UserModel userModel) {
        UserModel saveUser = userRepository.save(userModel);
        //用于测试事务支持
        // 主动引入空指针异常
        //String error = null;
        //error.split("/");
        return saveUser;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<UserModel> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<UserModel> findByNameLike(String name) {
        return userRepository.findByNameLike(name);
    }

    @Override
    public List<UserModel> findByIdIn(Collection<String> ids) {
        return userRepository.findByIdIn(ids);
    }
}
