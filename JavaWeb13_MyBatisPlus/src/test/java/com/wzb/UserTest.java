package com.wzb;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wzb.mapper.UserMapper;
import com.wzb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
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
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .lt("balance", 5000);
        List<User> userList = userMapper.selectList(queryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testLambdaQuery() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .gt(User::getBalance, 5000);
        List<User> userList = userMapper.selectList(queryWrapper);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert() {
        User user = new User(10, "第十二", "123456",
                "13100000010", 10000, LocalDateTime.now(), LocalDateTime.now());
        userMapper.insert(user);
    }

    @Test
    public void testDelete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .eq("id", 10);
        userMapper.delete(queryWrapper);
    }

    @Test
    public void testUpdate() {
        List<Integer> ids = List.of(7, 8, 9, 10);
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<User>()
                .in("id", ids);
        userMapper.updateBalance(updateWrapper, 2000);
    }
}
