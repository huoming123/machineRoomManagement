package com.design.machineManagementSystem.mapper;

import com.design.machineManagementSystem.pojo.Student;
import java.util.List;
import com.design.machineManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Student)表数据库访问层
 *
 * @author makejava
 */
public interface StudentMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Student> getPageSearchByCondition(@Param("page") Page<Student> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Student> page);


    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int increased(Student student);




    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int edit(Student student);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    Student getByUserNo(String userNo);
}

