package com.wzb.service.impl;

import com.wzb.dao.UserDao;
import com.wzb.dao.impl.UserDaoImpl;
import com.wzb.pojo.User;
import com.wzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao = new UserDaoImpl();

    /**
     * 得到UserDao传的未解析数据后，解析并封装成一个List<User>集合返回
     * @return List<User>集合
     */
    @Override
    public List<User> getUsers() {
        // 从UserDao中获取原始数据
        List<String> lines = userDao.getAll();
        // 解析原始数据
        return lines.stream().map(new Function<String, User>() {
            @Override
            public User apply(String line) {
                String[] split = line.split(",");
                Integer id = Integer.parseInt(split[0]);
                String username = split[1];
                String password = split[2];
                String name = split[3];
                Integer age = Integer.parseInt(split[4]);
                LocalDateTime updateTime = LocalDateTime.
                        parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                return new User(id, username, password, name, age, updateTime);
            }
        }).toList();
    }
}
