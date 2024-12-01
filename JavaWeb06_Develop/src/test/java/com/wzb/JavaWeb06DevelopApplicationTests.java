package com.wzb;

import com.wzb.mapper.UserMapper;
import com.wzb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JavaWeb06DevelopApplicationTests {

    private UserMapper userMapper;
    @Autowired
    public JavaWeb06DevelopApplicationTests(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void selectTest() {
        List<User> userList = userMapper.selectAllUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
