package com.wzb;

import com.wzb.mapper.UserMapper;
import com.wzb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class UserTest {

    private final UserMapper userMapper;

    @Autowired
    public UserTest(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void testQuery() {

    }

    @Test
    public void testInsert() {
        User user1 = new User(1, "张三", "123456", "13100000001", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User(2, "李四", "123456", "13100000002", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user3 = new User(3, "王五", "123456", "13100000003", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user4 = new User(4, "赵六", "123456", "13100000004", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user5 = new User(5, "钱七", "123456", "13100000005", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user6 = new User(6, "孙八", "123456", "13100000006", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user7 = new User(7, "老九", "123456", "13100000007", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user8 = new User(8, "第十", "123456", "13100000008", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user9 = new User(9, "第十一", "123456", "13100000009", 10000, LocalDateTime.now(), LocalDateTime.now());
        User user10 = new User(10, "第十二", "123456", "13100000010", 10000, LocalDateTime.now(), LocalDateTime.now());
        List<User> userList = new ArrayList<>();
        Collections.addAll(userList, user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
        for (User user : userList) {
            userMapper.insert(user);
        }
    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testUpdate() {

    }
}
