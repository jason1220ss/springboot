/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhongyuan.Yang
 * @Title: ExampleProperties
 * @Description: (自定义Property)
 * @date 2019-02-14 17:13
 */
@Component
public class ExampleProperties {

    @Value("${com.example.title}")
    private String title;
    @Value("${com.example.description}")
    private String description;

    // get && set 方法
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

