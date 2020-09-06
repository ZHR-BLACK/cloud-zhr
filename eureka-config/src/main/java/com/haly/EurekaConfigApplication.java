package com.haly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName EurekaConfigApplication
 * @Date 2020-08-31 18:13
 * @description 启动类
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigApplication.class, args);
    }

}
