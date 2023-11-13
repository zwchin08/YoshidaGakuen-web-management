package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     *这个list方法是用来查询全部部门数据的
     * 犹豫查询全部数据操作比较简单，所以蚕蛹基于注解的方式开发
     * */
    @Select("select * from tlias.dept")
    List<Dept> list();
    @Delete("delete from tlias.dept where id = #{id}")
    void deleteById(Integer id);
}
