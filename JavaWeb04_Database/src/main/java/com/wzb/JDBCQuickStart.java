package com.wzb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCQuickStart {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动，本质上是将驱动类加载到内存中，这一步是为了告诉程序用的是什么数据库
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/db01";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 获取SQL语句执行对象
        Statement statement = connection.createStatement();
        // 在SQL语句执行对象中执行SQL语句     statement:声明、报告、语句     execute:执行、实施
        statement.executeUpdate("update user set age = 20 where id = 1");
        // 处理完成后释放资源
        statement.close();
        connection.close();
    }
}
