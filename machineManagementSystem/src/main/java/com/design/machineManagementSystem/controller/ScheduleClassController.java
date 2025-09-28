package com.design.machineManagementSystem.controller;

import com.design.machineManagementSystem.pojo.ScheduleClass;
import com.design.machineManagementSystem.service.ScheduleClassService;
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
 * (ScheduleClass)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/scheduleClass")
public class ScheduleClassController {
    /**
     * 服务对象
     */
    @Autowired
    private ScheduleClassService scheduleClassService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<ScheduleClass>page) throws Exception{
        return this.scheduleClassService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<ScheduleClass> queryById(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.queryById(scheduleClass.getId());
    }

    /**
     * 新增数据
     *
     * @param scheduleClass 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.increased(scheduleClass);
    }

    /**
     * 编辑数据
     *
     * @param scheduleClass 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.edit(scheduleClass);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody ScheduleClass scheduleClass) {
        return this.scheduleClassService.deleteById(scheduleClass.getId());
    }

}

