package com.wzb;

import com.wzb.pojo.User;
import org.junit.Test;

import java.sql.*;

/**
 * JDBC查询数据库的用户信息并封装到User对象中
 */
public class JDBCQueryTest {

    @Test
    public void query() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/db01";
        String username = "root";
        String password = "123456";

        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 创建连接
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select id, username, password, name, age from user where username = ? and password = ?";
        // 这是预编译的SQL
        PreparedStatement statement = connection.prepareStatement(sql);
        // 通过Statement中的setString来对预编译的SQL中的占位符进行赋值
        statement.setString(1, "daqiao");
        statement.setString(2, "123456");
        // 得到查询的集合ResultSet
        ResultSet resultSet = statement.executeQuery();

        // 遍历结果集合并进行封装
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
            System.out.println(user);
        };

        // 释放资源
        statement.close();
        connection.close();
    }
}
