package com.wzb.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.wzb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 用户Mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    // 修改用户余额
    @Update("update user set balance = balance + #{amount} ${ew.customSqlSegment}")
    void updateBalance(@Param(Constants.WRAPPER)Wrapper <User> wrapper, @Param("amount")int amount);
}
