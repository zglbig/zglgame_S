package org.zgl.http;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @作者： big
 * @创建时间： 2018/6/11
 * @文件描述：自定义拦截器
 */
public class HttpHandlerInterceptor  implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.err.println("zxczxc");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //开始拦截
//        log.info("---------------------开始进入请求地址拦截----------------------------");
//        HttpSession session = httpServletRequest.getSession();
//        UserInfo userInfo = (UserInfo)session.getAttribute("user");
//        if(userInfo!=null){
//            return true;
//        }
//        else{
//            //PrintWriter printWriter = httpServletResponse.getWriter();
//            //printWriter.write("{code:0,message:\"会话已过期，请重新登录!\"}");
//            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin");
//            return false;
//        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //拦截完成
    }
}
