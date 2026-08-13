package com.siddh.FiltersAndInterceptorDemo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//to make use of it-> we have to explicitly add them in flow
@Component
public class RoleCheckInterceptor implements HandlerInterceptor {
    //handles logic before controller execution
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role=request.getHeader("Role");

        if(role==null || !role.equals("ADMIN")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("ONLY FOR ADMINS: ACCESS DENIED");
            return false;  //does not reach actual controller logic
        }

        System.out.println("Interceptor->User role is valid "+role);
        return true;
    }

    //executes after controller execution(before view rendering)
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor->post handle: Controller executed");
    }

    //executes after controller execution(after view rendering)
    //In Spring MVC, a view means the presentation page that is rendered and sent back to the client.Examples:
    //HTML page
    //Thymeleaf template
    //JSP page
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("Interceptor->afterCompletion: Controller executed");
    }
}
