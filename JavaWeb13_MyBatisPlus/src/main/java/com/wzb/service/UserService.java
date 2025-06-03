package com.wzb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzb.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {

    void addUser(User user);

    void deleteUser(Integer id);

    User queryUser(Integer id);

    List<User> queryBatchUser(List<Integer> ids);

    void updateBalance(Integer id, Integer amount);
}
