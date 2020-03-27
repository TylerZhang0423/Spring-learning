package com.example.demo.mail;

import com.example.demo.model.UserModel;

import java.util.List;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-03-25 21:56
 */
public interface SendJunkMailService {
    boolean sendJunkMail(List<UserModel> userModelList );
}
