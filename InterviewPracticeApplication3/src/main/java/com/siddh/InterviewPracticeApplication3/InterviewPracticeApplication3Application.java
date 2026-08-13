package com.siddh.InterviewPracticeApplication3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.JacksonJsonView;

@SpringBootApplication
public class InterviewPracticeApplication3Application {

	public static void main(String[] args) {

        SpringApplication.run(InterviewPracticeApplication3Application.class, args);
	}

    @Bean("JsonViewTemplate")
    public View name(){
        return new JacksonJsonView();
    }
}
