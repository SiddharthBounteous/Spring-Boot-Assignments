package com.siddh.OrderService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(){

        //internally it is called
        SimpleClientHttpRequestFactory factory=new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(1000);
        factory.setReadTimeout(5000);
        return new RestTemplate();
    }

//    @Bean
//    RestClient restClient(){
//        return RestClient.create();
//    }
//
//    @Bean
//    public ClientHttpRequestInterceptor clientHttpRequestInterceptor(){
//        return new MyCustomInterceptor();
//    }
}
