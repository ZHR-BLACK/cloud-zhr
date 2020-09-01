package com.haly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
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
@EnableFeignClients
public class EurekaClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient2Application.class, args);
    }

    //向spring里注入一个RestTemplate对象
    @Bean
    //负载均衡注解
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
