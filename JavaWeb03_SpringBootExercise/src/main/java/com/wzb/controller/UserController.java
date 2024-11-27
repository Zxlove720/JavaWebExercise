package com.wzb.controller;

import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.wzb.pojo.User;
import com.wzb.service.UserService;
import com.wzb.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService = new UserServiceImpl();
    private final List<User> userList = userService.findUser();

    @RequestMapping("/list")
    public String list() {
        return JSONUtil.toJsonStr(userList, JSONConfig.create().setDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

}
