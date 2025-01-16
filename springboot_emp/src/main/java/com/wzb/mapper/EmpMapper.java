package com.wzb.mapper;

import com.wzb.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from emp as e left join dept as d on e.dept_id = d.id")
    List<Emp> selectAllEmp();

}
