package com.wzb.controller;

import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.wzb.pojo.User;
import com.wzb.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    private UserService userService;
    @Resource(name = "userServiceImpl2")
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    // 获取用户数据的代码不能写在此处，类的成员变量初始化是在类的实例化阶段进行的，此时可能@AutoWired注入还未完成，导致Null
    // private final List<User> userList = userService.findUser();

    @RequestMapping("/list")
    public String list() {
        List<User> userList = userService.findUser();
        return JSONUtil.toJsonStr(userList, JSONConfig.create().setDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

}
