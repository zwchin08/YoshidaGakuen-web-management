package com.itheima.service;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
    /**
     *  查询全部部门
     **/
    List<Dept> list();
    /**
     * 用于删除部门
     * */
    void delete(Integer id);
}
