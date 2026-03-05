package com.siddh.SpringSecurityDemo2.service;

import com.siddh.SpringSecurityDemo2.dto.UserLogin;
import com.siddh.SpringSecurityDemo2.dto.UserRegister;
import com.siddh.SpringSecurityDemo2.repository.UserRepository;
import com.siddh.SpringSecurityDemo2.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtil;

    public Map<String,String>registerUser(UserRegister reg){
        if(userRepository.existsByUsername(reg.getUsername())){
            throw new RuntimeException("UserName already exists");
        }
        String role=(reg.getRole()==null) ? "USER" : reg.getRole().toUpperCase();

        com.siddh.SpringSecurityDemo2.model.User u=new com.siddh.SpringSecurityDemo2.model.User();

        u.setUsername(reg.getUsername());
        u.setPassword(encoder.encode(reg.getPassword()));
        u.setRole(role);
        userRepository.save(u);

        return Map.of("message", "User registered");
    }

    public Map<String,String>loginUser(UserLogin log){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(log.getUsername(),log.getPassword()));

        UserDetails ud=userDetailsService.loadUserByUsername(log.getUsername());
        String token=jwtUtil.generateToken(ud);
        return Map.of("token", token);
    }

}
