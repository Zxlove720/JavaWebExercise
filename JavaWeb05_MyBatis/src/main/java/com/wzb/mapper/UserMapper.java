package com.wzb.mapper;

import com.wzb.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
