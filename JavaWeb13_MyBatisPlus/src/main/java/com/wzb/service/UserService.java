package com.wzb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzb.pojo.User;
import com.wzb.pojo.UserQuery;

import java.util.List;


public interface UserService extends IService<User> {

    void updateBalance(Integer id, Integer amount);

    List<User> conditionQuery(UserQuery userQuery);
}
