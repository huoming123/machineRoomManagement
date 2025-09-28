package com.design.machineManagementSystem.service.impl;

import com.design.machineManagementSystem.pojo.Course;
import com.design.machineManagementSystem.mapper.CourseMapper;
import com.design.machineManagementSystem.service.CourseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.machineManagementSystem.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.machineManagementSystem.util.PageUtil;
import com.design.machineManagementSystem.dto.Page;
/**
 * (Course)表服务实现类
 *
 * @author makejava
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<Course> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Course> list= courseMapper.getPageSearchByCondition(page);
        //根据条件查询数据的条数
        Integer count = courseMapper.getPageSearchCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Course> queryById(Integer id) {
       Course course=this.courseMapper.queryById(id);
         return RestFulBean.succ(course);
    }

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(Course course) {
        if(course.getCourseName()==null){
            return RestFulBean.error("课程名称不能为空");
        }
        this.courseMapper.increased(course);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(Course course) {
        this.courseMapper.edit(course);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.courseMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Course>> getCourseList() {
        List<Course> list = courseMapper.getCourseList();
        return RestFulBean.succ(list);
    }
}
