package com.design.machineManagementSystem.controller;

import com.design.machineManagementSystem.pojo.Machine;
import com.design.machineManagementSystem.pojo.Teacher;
import com.design.machineManagementSystem.service.MachineService;
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
 * (Machine)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/machine")
public class MachineController {
    /**
     * 服务对象
     */
    @Autowired
    private MachineService machineService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Machine>page) throws Exception{
        return this.machineService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Machine> queryById(@RequestBody Machine machine) {
        return this.machineService.queryById(machine.getId());
    }

    /**
     * 新增数据
     *
     * @param machine 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Machine machine) {
        return this.machineService.increased(machine);
    }

    /**
     * 编辑数据
     *
     * @param machine 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Machine machine) {
        return this.machineService.edit(machine);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Machine machine) {
        return this.machineService.deleteById(machine.getId());
    }
    /**
     * @return 机房下拉
     */
    @PostMapping("/getMachineList")
    public RestFulBean<List<Machine>> getMachineList() throws Exception{
        return this.machineService.getMachineList();
    }
}

