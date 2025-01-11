package com.wzb.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.wzb.dao.UserDao;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    /**
     * 从文件中读取所有用户
      * @return 未解析的文件内容，每一行就是一个用户
     */
    @Override
    public List<String> getAll() {
        // 通过类加载器和相对路径的方式从文件中读取内容
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        return IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<String>());
    }
}
