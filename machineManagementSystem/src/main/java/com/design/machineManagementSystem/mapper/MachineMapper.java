package com.design.machineManagementSystem.mapper;

import com.design.machineManagementSystem.pojo.Machine;
import java.util.List;
import com.design.machineManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Machine)表数据库访问层
 *
 * @author makejava
 */
public interface MachineMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Machine queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Machine> getPageSearchByCondition(@Param("page") Page<Machine> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Machine> page);


    /**
     * 新增数据
     *
     * @param machine 实例对象
     * @return 影响行数
     */
    int increased(Machine machine);




    /**
     * 修改数据
     *
     * @param machine 实例对象
     * @return 影响行数
     */
    int edit(Machine machine);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Machine getByMachineRoom(String roomNo);

    List<Machine> getMachineList();
}

