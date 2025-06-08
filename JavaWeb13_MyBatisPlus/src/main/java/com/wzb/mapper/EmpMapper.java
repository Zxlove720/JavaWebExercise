package com.wzb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzb.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

/**
 * 员工Mapper
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
}
