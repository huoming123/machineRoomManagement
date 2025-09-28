package com.design.machineManagementSystem.mapper;

import com.design.machineManagementSystem.pojo.Repairs;
import java.util.List;
import com.design.machineManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Repairs)表数据库访问层
 *
 * @author makejava
 */
public interface RepairsMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Repairs queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Repairs> getPageSearchByCondition(@Param("page") Page<Repairs> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Repairs> page);


    /**
     * 新增数据
     *
     * @param repairs 实例对象
     * @return 影响行数
     */
    int increased(Repairs repairs);




    /**
     * 修改数据
     *
     * @param repairs 实例对象
     * @return 影响行数
     */
    int edit(Repairs repairs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Repairs> getRepairsAnalyse(Repairs repairs);
}

