package com.wzb.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzb.mapper.UserMapper;
import com.wzb.pojo.User;
import com.wzb.pojo.UserQuery;
import com.wzb.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 更新余额
     *
     * @param id 用户id
     * @param amount 修改金额
     */
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
                .like(userQuery.getUsername() != null && !userQuery.getUsername().isEmpty(), User::getUsername, userQuery.getUsername())
                .ge(userQuery.getMinBalance() != null, User::getBalance, userQuery.getMinBalance())
                .le(userQuery.getMaxBalance() != null, User::getBalance, userQuery.getMaxBalance())
                .list();
    }

    @Override
    public List<User> pageQuery(UserQuery userQuery) {
        Page<User> page = userQuery.toPage();
        Page<User> resultPage = page(page);
        // 3.1获取总记录数
        System.out.println("总记录数" + resultPage.getTotal());
        // 3.2获取总页数
        System.out.println("总页数" + resultPage.getPages());
        // 3.3获取总记录数
        return resultPage.getRecords();
    }

}
