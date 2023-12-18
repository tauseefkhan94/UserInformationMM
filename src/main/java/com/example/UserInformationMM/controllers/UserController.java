package com.example.UserInformationMM.controllers;

import com.example.UserInformationMM.model.User;
import com.example.UserInformationMM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public String getUser(@RequestParam String firstname,
                        @RequestParam String lastname) {
        String user = "";
        try {
            user = userService.getUser(firstname, lastname);
        } catch (Exception e) {

        }
        return user;
    }


    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
