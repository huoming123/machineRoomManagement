package com.design.machineManagementSystem.service.impl;

import com.design.machineManagementSystem.pojo.Student;
import com.design.machineManagementSystem.pojo.Teacher;
import com.design.machineManagementSystem.mapper.TeacherMapper;
import com.design.machineManagementSystem.service.TeacherService;
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
 * (Teacher)表服务实现类
 *
 * @author makejava
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<Teacher> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Teacher> list= teacherMapper.getPageSearchByCondition(page);
        //根据条件查询数据的条数
        Integer count = teacherMapper.getPageSearchCount(page);
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
    public RestFulBean<Teacher> queryById(Integer id) {
       Teacher teacher=this.teacherMapper.queryById(id);
         return RestFulBean.succ(teacher);
    }

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(Teacher teacher) {
        if(teacher.getUserName()==null){//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
            return RestFulBean.error("用户名不能为空");
        }
        if(teacher.getPassword()==null){
            return RestFulBean.error("密码不能为空");
        }
        if(teacher.getUserNo()==null)
        {
            return RestFulBean.error("学号不能为空");
        }

        if(teacher.getProfessional()==null)
        {
            return RestFulBean.error("专业不能为空");
        }
        Teacher teachered =teacherMapper.getByUserNo(teacher.getUserNo());//根据手机号查询该教师编号 是否注册了
        if(teachered!=null){ //如果不为空 说明手机号已经注册
            return RestFulBean.error("该教师编号已经注册");
        }
        this.teacherMapper.increased(teacher);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(Teacher teacher) {
        this.teacherMapper.edit(teacher);//执行数据库的修改语句 根据id 修改
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
        this.teacherMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Teacher>> getTeacherList() {
        List<Teacher> list =teacherMapper.getTeacherList();
        return RestFulBean.succ(list);
    }


}
