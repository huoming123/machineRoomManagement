package com.design.machineManagementSystem.service;

import com.design.machineManagementSystem.pojo.Repairs;
import com.design.machineManagementSystem.pojo.res.RestFulBean;
import com.design.machineManagementSystem.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
/**
 * (Repairs)表服务接口
 *
 * @author makejava
 */
public interface RepairsService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getPageSearch(Page<Repairs> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Repairs> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param repairs 实例对象
     * @return 实例对象
     */
    RestFulBean<String> increased(Repairs repairs);

    /**
     * 修改数据
     *
     * @param repairs 实例对象
     * @return 实例对象
     */
   RestFulBean<String> edit(Repairs repairs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> uploadRepairsFile(Integer id, MultipartFile coverFile)throws Exception ;

    RestFulBean<Map> getRepairsAnalyse(Repairs repairs);
}
