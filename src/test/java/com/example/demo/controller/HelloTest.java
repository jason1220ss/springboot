/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.example.demo.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.util.ExampleProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author zhongyuan.Yang
 * @Title: HelloTest
 * @Description: (测试)
 * @date 2019-02-13 17:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {
    private MockMvc mvc;
    @Autowired
    private ExampleProperties exampleProperties;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    public void getHello() throws Exception {
        String response = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON).param("id", "jason"))
                .andExpect(status().isOk()).andDo(print())
                .andReturn().getResponse().getContentAsString();
//                .andExpect(content().string(equalTo("Hello World, The First SpringBoot Project")));
        System.out.println("--------返回的json = " + response);
    }

    @Test
    public void getUser() throws Exception {
        String response = mvc.perform(MockMvcRequestBuilders.get("/getUser").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andReturn().getResponse().getContentAsString();
        System.out.println("User = " + response);
    }

    @Test
    public void getProperties () throws Exception {
        System.out.println(" Title = " + exampleProperties.getTitle());
        System.out.println(" Description = " + exampleProperties.getDescription());
        Assert.assertEquals(exampleProperties.getDescription(), "SpringBoot学习");
    }

}

