package com.haly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SpringcloudEurekaClientApplication
 * @Date 2020-08-31 18:16
 * @description 启动类
 **/
@SpringBootApplication
@EnableEurekaClient
public class SpringcloudEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaClientApplication.class, args);
    }

    //向spring里注入一个RestTemplate对象
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
