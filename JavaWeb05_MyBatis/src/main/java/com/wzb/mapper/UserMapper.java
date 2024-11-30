package com.wzb.mapper;

import com.wzb.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> selectAll();

    @Delete("delete from user where id=#{id}")
    public Integer deleteById(Integer id);

    @Insert("insert into user(id, username, password, name, age) " +
            "values (#{id}, #{username}, #{password}, #{name}, #{age})")
    public Integer insertUser(User user);

    @Update("update user set username=#{username}, password=#{password}, name=#{name}, age=#{age} where id=#{id}")
    public Integer updateUser(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    public User selectUser(@Param("username")String username, @Param("password")String password);
}
