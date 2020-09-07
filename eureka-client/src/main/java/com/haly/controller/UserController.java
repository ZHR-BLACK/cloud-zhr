package com.haly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


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

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getList")
    public String getUserList() {
        String url = "http://eureka-provider/user/getList";
        HttpMethod type = HttpMethod.GET;
        RequestEntity<String> paras = null;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, type, paras, String.class);
        return responseEntity.getBody();
    }

    @RequestMapping("/getList2")
    public String getUserList2() {
        //getForObject 调用无参方法，返回结果为String的方法
        String url = "http://eureka-provider/user/getList";
        String res = restTemplate.getForObject(url, String.class);
        return res;
    }

}
