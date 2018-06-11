package org.zgl.http;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @作者： big
 * @创建时间： 2018/6/11
 * @文件描述：
 */
public class HttpServerSimpleChannelInboundHandler {
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("zxczxc");
    }
}
