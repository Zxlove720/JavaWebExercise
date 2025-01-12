package com.wzb.mapper;

import com.wzb.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();

    @Delete("delete from user where id=#{id}")
    Integer deleteById(Integer id);

    @Insert("insert into user(id, username, password, name, age) " +
            "values (#{id}, #{username}, #{password}, #{name}, #{age})")
    Integer insertUser(User user);

    @Update("update user set username=#{username}, password=#{password}, name=#{name}, age=#{age} where id=#{id}")
    Integer updateUser(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    User selectUser(@Param("username") String username, @Param("password") String password);
}
