package com.itheima.controller;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 梳理一下流程；前端发送请求后会请求到Controller类下面的方法()；
 * 方法()会调用service——》在service中调用接口中的方法来获取数据
 *
 * */

//请求处理类
/**
 * 1.部门管理 Controller接收从浏览器的请求，通过 @RestController ——>找到对应类
 * 2.通过@RequestMapping来指定当前接口的请求路径
 * 3.这个方法就是用来查询部门信息的，返回值就是统一响应结果Result
 *
 * */

@Slf4j  //这个lombok提供的日志对象注解，就可以不用写下面的长代码了，就可以直接使用log对象调用相关的方法
@RestController //这是一个组合注解包括Respond 和Controller；而Respond会把返回值中的对象转换成Json再响应回来
public class DeptController {

    /**     第二步  最终DeptController是要调用Service的，在DeptController中注入Service对象 ,因为是面向接口编程所以使用的是接口*/
    @Autowired  //注入Service对象
    private DeptService deptService;
    /**   第一步  构建请求方法*/
    //创建log日志对象，这部分是固定代码
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
   // @RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求方式为GET
    @GetMapping("/depts")   //这个是上边的简写形式，直接指定使用是GET的请求方式；也有其他的指定方式
    public Result list(){
//        System.out.println("查询全部部门数据");//这种太低端，我们使用日志对象记录数据
        log.info("查询全部部门数据");   //成功会输出这句话，等价于System.out.println("查询全部部门数据")
        //调用service查询部门数据,因为查询的是全部对象所以使用的是集合
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 用于删除部门
     * */
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){//@PathVariable是用来接受上边的id的，并赋值给Integer的id
        log.info("根据id删除部门:{}",id);
        //调用service来删除部门
        deptService.delete(id);
        return Result.success();
    }



}
