package com.haly.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${env}")
    private String env;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfigMsg() {
        System.out.println("请求端口==================" + port);
        System.out.println("env==================" + env);
        return null;
    }
}
