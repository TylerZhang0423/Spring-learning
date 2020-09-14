package com.tyler;

import com.tyler.dao.UserDOMapper;
import com.tyler.dataobject.UserDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ Author     :tyler
 * @ Date       :2020/9/13
 * @ Time       :1:09 下午
 */
public class MybatisTest {

    @Autowired
    private UserDOMapper userDOMapper;

    @Test
    public void insertTest() {
        UserDO userDO = new UserDO();
        userDO.setAge(1);
        userDO.setGender("1");
        userDO.setName("1");
        userDOMapper.insertSelective(userDO);
    }
}
