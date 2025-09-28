package com.design.machineManagementSystem.mapper;

import com.design.machineManagementSystem.pojo.ScheduleClass;
import java.util.List;
import com.design.machineManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (ScheduleClass)表数据库访问层
 *
 * @author makejava
 */
public interface ScheduleClassMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScheduleClass queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<ScheduleClass> getPageSearchByCondition(@Param("page") Page<ScheduleClass> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<ScheduleClass> page);


    /**
     * 新增数据
     *
     * @param scheduleClass 实例对象
     * @return 影响行数
     */
    int increased(ScheduleClass scheduleClass);




    /**
     * 修改数据
     *
     * @param scheduleClass 实例对象
     * @return 影响行数
     */
    int edit(ScheduleClass scheduleClass);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    ScheduleClass getByDate(ScheduleClass scheduleClass);
}

