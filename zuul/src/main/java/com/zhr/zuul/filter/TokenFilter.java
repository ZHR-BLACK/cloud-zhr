package com.zhr.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TokenFilter
 * @Date 2020-09-01 16:47
 * @description TokenFilter
 **/
public class TokenFilter extends ZuulFilter {

    /**
     * 过滤器类型 pre表示在请求之前进行逻辑操作
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序
     * 当一个请求在同一个阶段存在多个过滤器的时候 过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * todo 是否开启过滤,这里为修改点
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 编写过滤器拦截业务逻辑代码
     */
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("token is null");
            currentContext.setResponseStatusCode(401);
        }
        return null;
    }

}
