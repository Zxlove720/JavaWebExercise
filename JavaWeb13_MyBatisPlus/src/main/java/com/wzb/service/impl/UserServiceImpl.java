package com.wzb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzb.mapper.UserMapper;
import com.wzb.pojo.User;
import com.wzb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void addUser(User user) {
        save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        removeById(id);
    }

    @Override
    public User queryUser(Integer id) {
        return getById(id);
    }

    @Override
    public List<User> queryBatchUser(List<Integer> ids) {
        List<User> userList = queryBatchUser(ids);
        return userList;
    }

    @Override
    public void updateBalance(Integer id, Integer amount) {

    }

}
