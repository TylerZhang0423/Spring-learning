package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.error.BusinessException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

//用户服务层实现类
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Resource
    private RedisTemplate redisTemplate;

    private static final String ALL_USER = "ALL_USER_LIST";

    @Override
    public UserModel findById(String id) {
        //step.1  查询Redis缓存中的所有数据
        List<UserModel> ayUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        if(ayUserList != null && ayUserList.size() > 0){
            for(UserModel user : ayUserList){
                if (user.getId().equals(id)){
                    return user;
                }
            }
        }
        //step.2  查询数据库中的数据
        UserModel userModel = userRepository.findById(id).get();
        if(userModel != null){
            //step.3 将数据插入到Redis缓存中
            redisTemplate.opsForList().leftPush(ALL_USER, userModel);
        }
        return userModel;
    }

    @Override
    public List<UserModel> findAll() {
        try{
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<UserModel> userList = userRepository.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成任务，耗时：" + (end - start) + "毫秒");
            return userList;
        }catch (Exception e){
            logger.error("method [findAll] error",e);
            return Collections.EMPTY_LIST;
        }
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

    Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
        logger.info("userId:" + id + "用户被删除");
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


    @Resource
    private UserDao userDao;

    @Override
    public UserModel findByNameAndPassword(String name , String password) {
        return userDao.findByNameAndPassword(name, password);
    }

    @Override
    @Async
    public Future<List<UserModel>> findAsynAll() {
        try{
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<UserModel> userList = userRepository.findAll();
            long end = System.currentTimeMillis();
            System.out.println("完成任务，耗时：" + (end - start) + "毫秒");
            return new AsyncResult<List<UserModel>>(userList) ;
        }catch (Exception e){
            logger.error("method [findAll] error",e);
            return new AsyncResult<List<UserModel>>(null);
        }
    }

    @Override
    @Retryable(value= {BusinessException.class},maxAttempts = 5,backoff = @Backoff(delay = 5000,multiplier = 2))
    public UserModel findByNameAndPasswordRetry(String name, String password) {
        logger.info("[findByNameAndPasswordRetry] 方法失败重试了！");
        throw new BusinessException();
    }

}
