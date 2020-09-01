package com.zhr.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName OrderRateLimiterFilter
 * @Date 2020-09-01 17:39
 * @description 令牌桶限流
 **/
@Component
public class OrderRateLimiterFilter extends ZuulFilter {

    //每秒产生10个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(10);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -4;
    }

    @Override
    public boolean shouldFilter() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        ///apigateway/order/api/v1/order/test
        System.out.println(request.getRequestURI());

        //限流的接口
        List<String> noFIlter = new ArrayList<>();
        noFIlter.add("/service-a/**");

        AntPathMatcher matcher = new AntPathMatcher();
        for (String pattern : noFIlter) {//pattern--/user/**
            if (StringUtils.isNotEmpty(pattern)
                    && matcher.match(pattern, request.getRequestURI())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {

        //可以用JMeter来进行测试
        RequestContext context = RequestContext.getCurrentContext();
        //tryAcquire达到最大流量时,立刻限流,也可以配置参数
        if (!RATE_LIMITER.tryAcquire()) {
            Map<String, Object> result = new HashMap<>();
            result.put("code", 429);
            result.put("msg", "目前访问量过大,限流了...");

            context.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
            context.setResponseBody(JSON.toJSONString(result));
            //解决中文乱码
            context.getResponse().setCharacterEncoding("UTF-8");
            context.getResponse().setContentType("text/html;charset=UTF-8");
        }

        return null;
    }
}
