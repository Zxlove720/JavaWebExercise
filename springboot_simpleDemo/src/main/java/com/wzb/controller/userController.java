package com.wzb.controller;

import cn.hutool.core.io.IoUtil;
import com.wzb.pojo.User;
import com.wzb.service.UserService;
import com.wzb.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
public class userController {
    @Autowired
    private UserService userService = new UserServiceImpl();


    @RequestMapping("/list")
    public List<User> getUsers() throws Exception {
//        // 1.从文件中读取用户信息
//        // 可以使用绝对路径从文件中读取，但是不推荐，建议使用类加载器读取相对路径
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        // 借助HuTool工具中的IoUtil读取
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
//        // 2.解析用户信息，封装为User对象
//        List<User> userList = lines.stream().map(new Function<String, User>() {
//            @Override
//            public User apply(String line) {
//                String[] split = line.split(",");
//                Integer id = Integer.parseInt(split[0]);
//                String username = split[1];
//                String password = split[2];
//                String name = split[3];
//                Integer age = Integer.parseInt(split[4]);
//                LocalDateTime updateTime = LocalDateTime.
//                        parse(split[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//                return new User(id, username, password, name, age, updateTime);
//            }
//        }).toList();
//        // 3.将User对象封装为List集合返回
//        return userList;

        return userService.getUsers();
    }
}
