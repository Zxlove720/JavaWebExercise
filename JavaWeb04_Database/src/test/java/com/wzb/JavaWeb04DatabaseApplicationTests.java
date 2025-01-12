package com.wzb;

import com.wzb.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootTest
class JavaWeb04DatabaseApplicationTests {
    /**
     * 使用JDBC编写DQL语句
     */
    @Test
    public void testDQL() throws Exception {
        // 注册数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 创建连接
        String url = "jdbc:mysql://localhost:3306/db01";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 编写SQL语句
        String sql = "select id, username, password, name, age from user where username = ? and password = ?";
        // 使用PreparedStatement对象创建预编译SQL
        PreparedStatement statement = connection.prepareStatement(sql);
        // 预编译SQL的两个参数都是String类型的，所以说使用setString方法补全其参数
        statement.setString(1, "zhouyu");
        statement.setString(2, "123456");
        // 调用executeQuery方法发起一条DQL语句，并将查询结果封装到ResultSet类中
        ResultSet resultSet = statement.executeQuery();
        // 遍历ResultSet结果集合，将查询结果封装为User实体类
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getInt("age")
            );
            System.out.println(user);
        }
        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
