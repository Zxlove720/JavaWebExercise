package com.wzb.service.impl;

import com.wzb.dao.UserDao;
import com.wzb.pojo.User;
import com.wzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service层实现类
 *
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    // 获取用户数据的代码不能写在此处，类的成员变量初始化是在类的实例化阶段进行的，此时可能@AutoWired注入还未完成，导致Null
    // private final List<String> lines = userDao.findUser();

    public List<User> findUser() {
        List<String> lines = userDao.findUser();
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).collect(Collectors.toList());
        return userList;
    }
}
