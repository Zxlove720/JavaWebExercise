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
        // 根据用户id获取用户
        User user = getById(id);
        // 判断用户的余额是否支持扣款
        if (user.getBalance() < amount) {
            // 此时余额不足，需要异常提醒
            System.out.println("余额不足");
            throw new RuntimeException("余额不足");
        }
        // 构造UpdateWrapper，添加判断条件
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<User>()
                .eq(User::getId, id);
        // 通过UserMapper中构造的方法修改用户余额
        userMapper.updateBalance(updateWrapper, amount);
    }

    /**
     * 用户条件查询
     *
     * @param userQuery 用户条件查询实体类
     * @return List<User> 用户列表
     */
    @Override
    public List<User> conditionQuery(UserQuery userQuery) {
        // 封装查询条件
        return lambdaQuery()
                // 模糊匹配
                .like(userQuery.getUsername() != null && !userQuery.getUsername().isEmpty(), User::getUsername, userQuery.getUsername())
                // 大于等于
                .ge(userQuery.getMinBalance() != null, User::getBalance, userQuery.getMinBalance())
                // 小于等于
                .le(userQuery.getMaxBalance() != null, User::getBalance, userQuery.getMaxBalance())
                .list();
    }

    /**
     * 分页查询
     *
     * @param userQuery 用户查询实体类
     * @return List<User> 用户列表
     */
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
