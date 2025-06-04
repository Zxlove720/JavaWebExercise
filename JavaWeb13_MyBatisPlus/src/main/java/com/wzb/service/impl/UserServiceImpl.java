package com.wzb.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzb.mapper.UserMapper;
import com.wzb.pojo.User;
import com.wzb.pojo.UserQuery;
import com.wzb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void updateBalance(Integer id, Integer amount) {
        User user = getById(id);
        if (user.getBalance() < amount) {
            System.out.println("余额不足");
            throw new RuntimeException("余额不足");
        }
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>()
                .eq(User::getId, id);
        userMapper.updateBalance(updateWrapper, amount);
    }

    @Override
    public List<User> conditionQuery(UserQuery userQuery) {
        return lambdaQuery()
                .like(userQuery.getUsername() != null, User::getUsername, userQuery.getUsername())
                .ge(userQuery.getMinBalance() != null, User::getBalance, userQuery.getMinBalance())
                .le(userQuery.getMinBalance() != null, User::getBalance, userQuery.getMinBalance())
                .list();
    }

}
