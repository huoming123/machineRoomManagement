package com.design.machineManagementSystem.controller;

import com.design.machineManagementSystem.pojo.Course;
import com.design.machineManagementSystem.pojo.Machine;
import com.design.machineManagementSystem.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.machineManagementSystem.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.machineManagementSystem.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Course)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    /**
     * 服务对象
     */
    @Autowired
    private CourseService courseService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Course>page) throws Exception{
        return this.courseService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Course> queryById(@RequestBody Course course) {
        return this.courseService.queryById(course.getId());
    }

    /**
     * 新增数据
     *
     * @param course 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Course course) {
        return this.courseService.increased(course);
    }

    /**
     * 编辑数据
     *
     * @param course 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Course course) {
        return this.courseService.edit(course);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Course course) {
        return this.courseService.deleteById(course.getId());
    }
    /**
     * @return 机房下拉
     */
    @PostMapping("/getCourseList")
    public RestFulBean<List<Course>> getCourseList() throws Exception{
        return this.courseService.getCourseList();
    }
}

