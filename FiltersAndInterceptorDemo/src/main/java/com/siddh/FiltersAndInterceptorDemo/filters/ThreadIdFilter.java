package com.siddh.FiltersAndInterceptorDemo.filters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ThreadIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //we are mapping each thread with each request
        System.out.println("Filter->ThreadIdFilter->Preprocessing in filter");

        //doing something in request
        long threadId=Thread.currentThread().threadId();
        servletRequest.setAttribute("threadId",threadId);

        filterChain.doFilter(servletRequest,servletResponse); //calls next filter


        System.out.println("Filter->ThreadIdFilter->Postprocessing in filter");
    }
}
