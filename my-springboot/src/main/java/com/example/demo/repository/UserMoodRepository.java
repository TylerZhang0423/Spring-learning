package com.example.demo.repository;

import com.example.demo.model.UserMood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-04-18 23:03
 */
public interface UserMoodRepository extends JpaRepository<UserMood, String>{
}
