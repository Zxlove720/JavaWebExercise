package com.wzb.mapper;

import com.wzb.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
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

    /**
     * 根据id删除部门
     * @param id 部门id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
}
