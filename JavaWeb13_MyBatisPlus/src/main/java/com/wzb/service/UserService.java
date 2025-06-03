package com.wzb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzb.pojo.User;


public interface UserService extends IService<User> {

    void updateBalance(Integer id, Integer amount);

}
