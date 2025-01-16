package com.wzb.mapper;

import com.wzb.pojo.Dept;
import org.apache.ibatis.annotations.*;

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

    /**
     * 根据id查询部门
     * @return Dept 对象
     */
    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);

    /**
     * 修改部门信息
     * @param dept Dept实体对象
     */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void updateDept(Dept dept);
}
