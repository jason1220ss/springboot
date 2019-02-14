/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.example.demo.domain;

/**
 * @author zhongyuan.Yang
 * @Title: User
 * @Description: (实体类)
 * @date 2019-02-14 11:11
 */
public class User {
    private String uId;
    private String name;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

