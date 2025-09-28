package com.design.machineManagementSystem.service.impl;

import com.design.machineManagementSystem.pojo.Student;
import com.design.machineManagementSystem.mapper.StudentMapper;
import com.design.machineManagementSystem.service.StudentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.machineManagementSystem.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.design.machineManagementSystem.util.PageUtil;
import com.design.machineManagementSystem.dto.Page;
/**
 * (Student)表服务实现类
 *
 * @author makejava
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getPageSearch(Page<Student> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Student> list= studentMapper.getPageSearchByCondition(page);
        //根据条件查询数据的条数
        Integer count = studentMapper.getPageSearchCount(page);
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
    public RestFulBean<Student> queryById(Integer id) {
       Student student=this.studentMapper.queryById(id);
         return RestFulBean.succ(student);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> increased(Student student) {
        if(student.getUserName()==null){//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
            return RestFulBean.error("用户名不能为空");
        }
        if(student.getPassword()==null){
            return RestFulBean.error("密码不能为空");
        }
        if(student.getUserNo()==null)
        {
            return RestFulBean.error("学号不能为空");
        }

        if(student.getProfessional()==null)
        {
            return RestFulBean.error("专业不能为空");
        }
        if(student.getClassess()==null)
        {
            return RestFulBean.error("班级不能为空");
        }
        Student studented =studentMapper.getByUserNo(student.getUserNo());//根据手机号查询该学号是否注册了
        if(studented!=null){ //如果不为空 说明手机号已经注册
            return RestFulBean.error("该学号已经注册");
        }
        this.studentMapper.increased(student);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> edit(Student student) {
        this.studentMapper.edit(student);//执行数据库的修改语句 根据id 修改
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
        this.studentMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }
}
