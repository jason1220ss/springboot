/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongyuan.Yang
 * @Title: HelloWorldController
 * @Description: (SpringBoot入门)
 * @date 2019-02-13 17:01
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index(String id) {
        if (id.equals("jason")) {
            return "Hello World, The First SpringBoot Project";
        } else {
            return "Error";
        }
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setuId("1");
        user.setName("jason");
        return user;
    }
}

