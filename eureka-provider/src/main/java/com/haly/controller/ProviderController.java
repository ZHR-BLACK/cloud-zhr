package com.haly.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ProviderController
 * @Date 2020-08-31 18:17
 * @description ProviderController
 **/
@RestController
public class ProviderController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "zhr") String name) {
        return name + ",welcome to springcloud! server port:" + port;
    }
}
