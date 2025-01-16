package com.wzb.mapper;

import com.wzb.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {

    /**
     * 查询所有部门
     * @return 部门集合
     */
    @Select("select * from dept")
    List<Dept> selectAllDept();

}
