package com.siddh.FiltersAndInterceptorDemo.filters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//count the no. of request landing on this application
@Component
public class RequestCounterFilter implements Filter {
    private int counter=0;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter->RequestCounterFilter->Preprocessing in filter");

        counter++;

        //doing something in request
        servletRequest.setAttribute("requestNumber",counter);

        filterChain.doFilter(servletRequest,servletResponse); //calls next filter

        //doing something in response
        servletResponse.getWriter().write("Request #"+counter+" processed");

        System.out.println("Filter->RequestCounterFilter->Postprocessing in filter");
    }
}
