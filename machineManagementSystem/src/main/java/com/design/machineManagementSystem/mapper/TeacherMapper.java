package com.design.machineManagementSystem.mapper;

import com.design.machineManagementSystem.pojo.Student;
import com.design.machineManagementSystem.pojo.Teacher;
import java.util.List;
import com.design.machineManagementSystem.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Teacher)表数据库访问层
 *
 * @author makejava
 */
public interface TeacherMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Teacher> getPageSearchByCondition(@Param("page") Page<Teacher> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageSearchCount(@Param("page") Page<Teacher> page);


    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int increased(Teacher teacher);




    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int edit(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Teacher getByUserNo(String userNo);

    List<Teacher> getTeacherList();
}

