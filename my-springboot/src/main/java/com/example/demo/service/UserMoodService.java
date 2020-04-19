package com.example.demo.service;

import com.example.demo.model.UserMood;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-04-18 23:08
 */
public interface UserMoodService {
    UserMood save (UserMood userMood);
    String asynSave(UserMood userMood) ;
}
