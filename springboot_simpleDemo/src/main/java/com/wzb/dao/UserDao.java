package com.wzb.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    /**
     * 从文件中读取所有用户
      * @return 未解析的文件内容，每一行就是一个用户
     */
    List<String> getAll();

}
