package com.wzb.service;

import com.wzb.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    /**
     * 得到UserDao传的未解析数据后，解析并封装成一个List<User>集合返回
     * @return List<User>集合
     */
    List<User> getUsers();

}
