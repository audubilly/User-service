package com.billy.userservice.controller;


import com.billy.userservice.VO.ResponseTemplateVO;
import com.billy.userservice.entity.User;
import com.billy.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside tgetUserWithDepartment Method of the UserController");
        return userService.getUserWithDepartment(userId);
    }
}
