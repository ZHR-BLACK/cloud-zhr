package com.haly.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 定义一些bean注入配置
 */
@Configuration
public class ConfigBean {

    //向spring里注入一个RestTemplate对象
    @Bean
    //负载均衡注解
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    // 换成别的负载方法
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }

}
