package com.wzb;

import com.wzb.pojo.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * JDBC查询数据库的用户信息并封装到User对象中
 */
public class JDBCQueryTest {

//    @Test
//    public void query() throws ClassNotFoundException, SQLException {
//        String url = "jdbc:mysql://localhost:3306/db01";
//        String username = "root";
//        String password = "123456";
//
//        // 注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        // 创建连接
//        Connection connection = DriverManager.getConnection(url, username, password);
//        String sql = "select id, username, password, name, age from user where username = ? and password = ?";
//        // 这是预编译的SQL
//        PreparedStatement statement = connection.prepareStatement(sql);
//        // 通过Statement中的setString来对预编译的SQL中的占位符进行赋值
//        statement.setString(1, "daqiao");
//        statement.setString(2, "123456");
//        // 得到查询的集合ResultSet
//        ResultSet resultSet = statement.executeQuery();
//
//        // 遍历结果集合并进行封装
//        while (resultSet.next()) {
//            User user = new User(
//                    resultSet.getInt("id"),
//                    resultSet.getString("username"),
//                    resultSet.getString("password"),
//                    resultSet.getString("name"),
//                    resultSet.getInt("age"));
//            System.out.println(user);
//        };
//
//        // 释放资源
//        statement.close();
//        connection.close();
//    }

    @Test
    public void query() throws Exception {
        String url = "jdbc:mysql://localhost:3306/db01";
        String username = "root";
        String password = "123456";
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 创建连接
        Connection connection = DriverManager.getConnection(url, username, password);
        // 使用预编译SQL进行查询
        String sql = "select id, username, password, name, age from user where username = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 为预编译SQL中的占位符赋值     第几个占位符 + 值
        statement.setString(1, "liubei");
        statement.setString(2, "123456");
        // 进行查询，得到ResultSet集合
        // ResultSet中存储的是每一行记录，可以通过其中的next方法，是通过一个移动的指针完成的。
        // 假如该索引还有记录，就返回true和该索引的记录，并往后移动指针
        ResultSet resultSet = statement.executeQuery();
        // 遍历查询的结果，将字段封装为User实体对象，并封装到ArrayList集合中
        ArrayList<User> arrayList = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
            arrayList.add(user);
        }
        for (User user : arrayList) {
            System.out.println(user);
        }

    }
}
