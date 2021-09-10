package com.billy.userservice.service;

import com.billy.userservice.entity.User;
import com.billy.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        log.info("inside the saveUser method of the userService");
        return userRepository.save(user);
    }
}
