package com.example.demo.controller;

import java.util.List;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * @author: zhongyuan.Yang
 * @Title: TestRedis
 * @Description:
 * @date 2019/3/7 9:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    private MockMvc mvc;
    private Jedis jedis;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(), "106.52.95.206", 6379, 3000,
                "yzy0802redis");
        jedis = jedisPool.getResource();
    }

    @Test
    public void myRedis() {
        /*JedisPool jedisPool = new JedisPool(new GenericObjectPoolConfig(), "123.207.89.45", 6378, 3000,
                "redis1234@!");
        Jedis jedis = jedisPool.getResource();*/
        List<String> list = jedis.lrange("yzy",0,3);
        System.out.println(list);
//        String[] members = new String[] {"a", "b", "c"};
//        jedis.sadd("", members);
    }

    @Test
    public void testSubscribe() {
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println(channel);
                System.out.println(message);
            }
        };
        jedis.subscribe(jedisPubSub, "channel1");
    }

    @Test
    public void testPublish() {
        String channel = "channel";
        String message = "Test Publish Subscribe";
        jedis.publish(channel, message);
    }
}
