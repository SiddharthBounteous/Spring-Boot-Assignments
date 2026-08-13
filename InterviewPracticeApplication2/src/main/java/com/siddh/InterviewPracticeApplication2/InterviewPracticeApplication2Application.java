package com.siddh.InterviewPracticeApplication2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.webmvc.autoconfigure.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration  //allows to create beans in this main class itself
//@ComponentScan
@ComponentScan(basePackages = "com.siddh.InterviewPracticeApplication2.controller")
//@EnableAutoConfiguration(exclude = {DispatcherServletAutoConfiguration.class})  //will exclude creating of this preconfigured bean
@EnableAutoConfiguration
public class InterviewPracticeApplication2Application {

	public static void main(String[] args) {

        SpringApplication.run(InterviewPracticeApplication2Application.class, args);
	}

    @Bean
    public Faculty createFaculty(){
        return new Faculty();
    }
}
