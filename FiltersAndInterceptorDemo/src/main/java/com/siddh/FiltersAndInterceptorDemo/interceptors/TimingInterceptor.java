package com.siddh.FiltersAndInterceptorDemo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//logging the time of api request
@Component
public class TimingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime=System.currentTimeMillis();
        System.out.println("INTERCEPTOR -> ["+request.getMethod()+" "+request.getRequestURI()+"] start time "+startTime+" ms");
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        Long startTime=(long) request.getAttribute("startTime");
        if(startTime!=null){
            long duration=System.currentTimeMillis()-startTime;
            System.out.println("INTERCEPTOR -> ["+request.getMethod()+" "+request.getRequestURI()+"] took "+duration+" ms");
        }
    }
}
