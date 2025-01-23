package com.wzb.controller;

import com.wzb.annotation.LogOperation;
import com.wzb.pojo.Emp;
import com.wzb.pojo.LoginInfo;
import com.wzb.pojo.Result;
import com.wzb.service.EmpService;
import com.wzb.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private final EmpService empService;

    @Autowired
    public LoginController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping
    @LogOperation
    public Result<LoginInfo> login(@RequestBody Emp emp) {
        log.info("员工{}正在登录", emp.getUsername());
        LoginInfo loginInfo = empService.login(emp);
        if (loginInfo != null) {
            log.info("员工{}登录成功", emp.getUsername());
            ThreadUtils.setCurrentId(loginInfo.getId());
            return Result.success(loginInfo);
        }
        log.info("员工{}登录失败", emp.getUsername());
        return Result.error("用户名或密码错误");
    }
}
