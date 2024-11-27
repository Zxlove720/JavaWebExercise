package com.wzb.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.wzb.dao.UserDao;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao层的实现类
 *
 */
@Component
public class UserDaoImpl implements UserDao {

    @Override
    public List<String> findUser() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        return IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
    }
}
