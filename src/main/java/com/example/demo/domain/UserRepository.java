package com.example.demo.domain;/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhongyuan.Yang
 * @Title: UserRepository
 * @Description: (描述此类的功能)
 * @date 2019-02-15 17:54
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName, String email);
    // 分页查询
    @Override
    Page<User> findAll(Pageable pageable);
    Page<User> findByUserName(String userName,Pageable pageable);
    // 限制查询
    List<User> findFirst2ByEmail(String email);
    User findTopByUserName(String userName);
    // 自定义Sql查询
    @Transactional
    @Modifying
    @Query("update User u set u.userName = ?1 where u.id = ?2")
    int updateUserById(String userName, Long id);
    // 事物执行时长（超时秒数）
    @Transactional(timeout = 2)
    @Query("select u from User u where u.id = ?1")
    User selectUserById(Long id);
}
