package com.siddh.SpringSecurityDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        UserDetails user=User.builder()
                .username("user")
                .password(encoder.encode("user123"))
                .roles("USER")
                .build();
        UserDetails manager=User.builder()
                .username("manager")
                .password(encoder.encode("manager123"))
                .roles("MANAGER")
                .build();
        UserDetails hr=User.builder()
                .username("hr")
                .password(encoder.encode("hr123"))
                .roles("HR")
                .build();

        UserDetails admin=User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin,hr, manager);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
