package com.wzb.mapper;

import com.wzb.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    /**
     * 新增部门
     * @param dept 封装的dept对象
     */
    @Insert("insert into dept (name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void insertDept(Dept dept);
}
