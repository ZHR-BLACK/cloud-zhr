package com.haly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SpringcloudEurekaServerApplication
 * @Date 2020-08-31 18:13
 * @description 启动类
 **/
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class EurekaProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider2Application.class, args);
    }

}
