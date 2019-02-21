package com.example.demo.domain;/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhongyuan.Yang
 * @Title: UserRepository
 * @Description: (描述此类的功能)
 * @date 2019-02-15 17:54
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName, String email);
}
