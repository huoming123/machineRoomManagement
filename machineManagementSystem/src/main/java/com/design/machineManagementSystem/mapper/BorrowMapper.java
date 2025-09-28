package com.design.machineManagementSystem.mapper;

import com.design.machineManagementSystem.pojo.Borrow;
import java.util.List;
import com.design.machineManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Borrow)表数据库访问层
 *
 * @author makejava
 */
public interface BorrowMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Borrow queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Borrow> getPageSearchByCondition(@Param("page") Page<Borrow> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Borrow> page);


    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 影响行数
     */
    int increased(Borrow borrow);




    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 影响行数
     */
    int edit(Borrow borrow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Borrow> getByStudentId(Borrow borrow);

    List<Borrow> getByTeacherId(Borrow borrow);

    List<Borrow> getByTime(Borrow borrow);

    List<Borrow> getBorrowAnalyse(Borrow borrow);
}

