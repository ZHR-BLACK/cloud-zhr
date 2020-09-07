package com.haly.controller;

import com.haly.bean.User;
import com.haly.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UserController
 * @Date 2020-09-07 10:27
 * @description UserController
 **/
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/getList")
    public List<User> getList() {
        List<User> list = userService.getList();
        System.out.println(list);
        return list;
    }

}
