package com.example.demo.domain;

import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: zhongyuan.Yang
 * @Title: UserRepositoryTest
 * @Description:
 * @date 2019/2/18 16:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testUser() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        // 通过id查询 getOne() && findOne() 用不了
        User user = userRepository.findById(1L).get();
        System.out.println(" 通过id查询User = " + user.getUserName());
        // 通过userName查询
        User user1 = userRepository.findByUserName("yzy");
        System.out.println(" 通过userName查询User1 = " + user1.getEmail());
        // 通过userName和Email查询
        User user2 = userRepository.findByUserNameOrEmail("bb2", "bb@126.com");
        System.out.println(" 通过userName和Email查询User2 = " + user2.getNickName());
        // 插入一条数据
        userRepository.save(new User(2L,"aa1", "aa", "aa@126.com", "aa123456",formattedDate));
        // 验证数据总数
        Assert.assertEquals(3, userRepository.findAll().size());
        // 验证根据userName和Email查询到的nickName是否等于"bb123456"
        Assert.assertEquals("bb123456", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getNickName());
        // 删除一条数据
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
