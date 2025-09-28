package com.design.machineManagementSystem.controller;

import com.design.machineManagementSystem.pojo.Student;
import com.design.machineManagementSystem.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.machineManagementSystem.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.machineManagementSystem.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Student)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * 服务对象
     */
    @Autowired
    private StudentService studentService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Student>page) throws Exception{
        return this.studentService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Student> queryById(@RequestBody Student student) {
        return this.studentService.queryById(student.getId());
    }

    /**
     * 新增数据
     *
     * @param student 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Student student) {
        return this.studentService.increased(student);
    }

    /**
     * 编辑数据
     *
     * @param student 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Student student) {
        return this.studentService.edit(student);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Student student) {
        return this.studentService.deleteById(student.getId());
    }

}

