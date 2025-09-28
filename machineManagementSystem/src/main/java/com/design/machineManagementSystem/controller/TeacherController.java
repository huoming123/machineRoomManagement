package com.design.machineManagementSystem.controller;

import com.design.machineManagementSystem.pojo.Teacher;
import com.design.machineManagementSystem.service.TeacherService;
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
 * (Teacher)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Autowired
    private TeacherService teacherService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Teacher>page) throws Exception{
        return this.teacherService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Teacher> queryById(@RequestBody Teacher teacher) {
        return this.teacherService.queryById(teacher.getId());
    }

    /**
     * 新增数据
     *
     * @param teacher 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Teacher teacher) {
        return this.teacherService.increased(teacher);
    }

    /**
     * 编辑数据
     *
     * @param teacher 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Teacher teacher) {
        return this.teacherService.edit(teacher);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Teacher teacher) {
        return this.teacherService.deleteById(teacher.getId());
    }
    /**
     * @return 教师下拉
     */
    @PostMapping("/getTeachList")
    public RestFulBean<List<Teacher>> getTeacherList() throws Exception{
        return this.teacherService.getTeacherList();
    }
}

