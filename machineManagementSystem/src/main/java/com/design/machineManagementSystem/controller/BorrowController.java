package com.design.machineManagementSystem.controller;

import com.design.machineManagementSystem.pojo.Borrow;
import com.design.machineManagementSystem.service.BorrowService;
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
 * (Borrow)表控制层
 *
 * @author makejava
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    /**
     * 服务对象
     */
    @Autowired
    private BorrowService borrowService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getPageSearch(@RequestBody Page<Borrow>page) throws Exception{
        return this.borrowService.getPageSearch(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/query/by/id")
    public RestFulBean<Borrow> queryById(@RequestBody Borrow borrow) {
        return this.borrowService.queryById(borrow.getId());
    }

    /**
     * 新增数据
     *
     * @param borrow 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Borrow borrow) {
        return this.borrowService.increased(borrow);
    }

    /**
     * 编辑数据
     *
     * @param borrow 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Borrow borrow) {
        return this.borrowService.edit(borrow);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Borrow borrow) {
        return this.borrowService.deleteById(borrow.getId());
    }
    /**
     * 借用统计分析
     *
     * @param tBor 实体
     * @return 编辑结果
     */
    @PostMapping("/getBorrowAnalyse")
    public RestFulBean<Map> getBorrowAnalyse(@RequestBody  Borrow borrow) {
        return this.borrowService.getBorrowAnalyse(borrow);
    }
}

