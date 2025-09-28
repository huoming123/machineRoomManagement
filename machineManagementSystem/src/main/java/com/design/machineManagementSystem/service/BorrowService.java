package com.design.machineManagementSystem.service;

import com.design.machineManagementSystem.pojo.Borrow;
import com.design.machineManagementSystem.pojo.res.RestFulBean;
import com.design.machineManagementSystem.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Borrow)表服务接口
 *
 * @author makejava
 */
public interface BorrowService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getPageSearch(Page<Borrow> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Borrow> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    RestFulBean<String> increased(Borrow borrow);

    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
   RestFulBean<String> edit(Borrow borrow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);



    RestFulBean<Map> getBorrowAnalyse(Borrow borrow);
}
