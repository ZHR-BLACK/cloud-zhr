package com.haly.service;

import com.haly.bean.User;
import com.haly.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserServiceImpl
 * @Date 2020-09-07 10:26
 * @description UserServiceImpl
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getList() {
        return userRepository.getList();
    }
}
