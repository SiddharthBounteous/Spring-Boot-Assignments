package com.siddh.springdatajpademo2.service;

import com.siddh.springdatajpademo2.entity.User;
import com.siddh.springdatajpademo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void setUserDetails(User user){
        if(user.getName()!=null){
            user.setName(user.getName());
            user.setId(user.getId());
        }
        userRepository.save(user);
    }

    public User getUserDetailsById(Long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

}
