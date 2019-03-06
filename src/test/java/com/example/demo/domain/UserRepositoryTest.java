package com.example.demo.domain;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        /*User user = userRepository.findById(1L).get();
        System.out.println(" 通过id查询User = " + user.getUserName());
        // 通过userName查询
        User user1 = userRepository.findByUserName("yzy");
        System.out.println(" 通过userName查询User1 = " + user1.getEmail());
        // 通过userName和Email查询
        User user2 = userRepository.findByUserNameOrEmail("bb2", "bb@126.com");
        System.out.println(" 通过userName和Email查询User2 = " + user2.getNickName());*/
        // 插入一条数据
        userRepository.save(new User(6L,"aa1", "aa", "aa@126.com", "aa123456",formattedDate));
        // 验证数据总数
        /*Assert.assertEquals(3, userRepository.findAll().size());
        // 验证根据userName和Email查询到的nickName是否等于"bb123456"
        Assert.assertEquals("bb123456", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getNickName());
        // 删除一条数据
        userRepository.delete(userRepository.findByUserName("aa1"));*/
    }

    @Test
    public void testPage() throws Exception {
        /*Pageable pageable = PageRequest.of(0,2);
        Page<User> users = userRepository.findAll(pageable);
        System.out.println(" 分页查询 = " + users.getTotalElements());
        Page<User> userPage = userRepository.findByUserName("yzy", pageable);
        System.out.println(" 条件分页查询 = " + userPage.getTotalElements());*/

        /*List<User> userList = userRepository.findFirst2ByEmail("aa@126.com");
        System.out.println(" 限制查询 = " + userList.size());
        User user = userRepository.findTopByUserName("aa1");
        System.out.println(" 限制查询 user = " + user.getRegTime());*/

        int num = userRepository.updateUserById("jasonZ", 6L);
        System.out.println(" 自定义查询是否成功: " + (1 == num));
        User user1 = userRepository.selectUserById(2L);
        System.out.println(" 自定义查询:{用户名：" + user1.getUserName() + ", 密码：" + user1.getPassWord() + "}");
    }
}
