package com.example.UserInformationMM.controllers;

import com.example.UserInformationMM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping("/userListBetweenDateRange")
    public List<String> getuserListBetweenDateRange(@RequestParam String startDate,
                          @RequestParam String endDate) {
        List<String> users = new ArrayList<>();
        try {
            users = userService.getuserListBetweenDateRange(startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @RequestMapping("/userListPerProfession")
    public List<String> getuserListPerProfession(@RequestParam String profession) {
        List<String> users = new ArrayList<>();
        try {
            users = userService.getuserListPerProfession(profession);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}
