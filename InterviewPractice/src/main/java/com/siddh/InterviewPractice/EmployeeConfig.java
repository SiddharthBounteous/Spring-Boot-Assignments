package com.siddh.InterviewPractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EmployeeConfig {

    @Bean("FirstEmployee")
    public Employee getEmployee1(){
        return new Employee(1L,"Siddharth");
    }

    @Bean("SecondEmployee")
    @Primary
    public Employee getEmployee2(){
        return new Employee(2L,"Rohan");
    }

    //@Primary->tells spring to use that bean by default when multiple candidates of same type exist, when we don't explicitly specify @Qualifier

    //two different beans but there return type is same
}
