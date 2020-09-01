package com.zhr.zuul;

import com.zhr.zuul.filter.OrderRateLimiterFilter;
import com.zhr.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    // 实例化tokenfilter,否则网管不生效
    @Bean
    TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    OrderRateLimiterFilter orderRateLimiterFilter() {
        return new OrderRateLimiterFilter();
    }
}
