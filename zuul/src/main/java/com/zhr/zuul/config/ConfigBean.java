package com.zhr.zuul.config;

import com.zhr.zuul.filter.OrderRateLimiterFilter;
import com.zhr.zuul.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

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
