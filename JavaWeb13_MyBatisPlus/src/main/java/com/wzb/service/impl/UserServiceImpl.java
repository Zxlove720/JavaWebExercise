package com.wzb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzb.mapper.UserMapper;
import com.wzb.pojo.User;
import com.wzb.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



}
