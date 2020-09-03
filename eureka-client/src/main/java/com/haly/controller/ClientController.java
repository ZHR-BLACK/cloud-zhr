package com.haly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ClientController
 * @Date 2020-08-31 18:17
 * @description ClientController
 **/
@RestController
public class ClientController {

    @Value("${server.port}")
    String port;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "zhr") String name) {
        return name + ",welcome to springcloud! server port:" + port;
    }

    @GetMapping("/helloworld")
    public String helloWorld() {
        return restTemplate.getForEntity("http://eureka-provider/hello", String.class).getBody();
    }


}
