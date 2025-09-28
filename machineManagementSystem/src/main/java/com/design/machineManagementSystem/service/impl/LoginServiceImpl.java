package com.design.machineManagementSystem.service.impl;

import com.design.machineManagementSystem.mapper.StudentMapper;
import com.design.machineManagementSystem.mapper.TeacherMapper;
import com.design.machineManagementSystem.pojo.*;
import com.design.machineManagementSystem.mapper.ManagerMapper;
import com.design.machineManagementSystem.pojo.Users;
import com.design.machineManagementSystem.pojo.res.RestFulBean;
import com.design.machineManagementSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class  LoginServiceImpl implements LoginService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public RestFulBean<Users> login(Users users) throws Exception {
        if(users.getUserNo()==null)
        {
            return RestFulBean.error("编号不能为空");
        }
        if(users.getPassword()==null)
        {
            return RestFulBean.error("密码不能为空");
        }
        if(users.getRole()==null)
        {
            return RestFulBean.error("角色不能为空");
        }
        Users user =new Users(); //new一个用户对象
        user.setRole(users.getRole());
        if(users.getRole().equals("学生")) //判断角色是否等于学生
        {

            Student student =studentMapper.getByUserNo(users.getUserNo());//根据编号获取学生数据
            if(student==null){
                return RestFulBean.error("该学生用户不存在");
            }
            if(student.getChecked()==0){
            return RestFulBean.error("账号还未审核");
        }
            if(student.getChecked()==-1){
                return RestFulBean.error("账号审核不通过");
            }
            //赋值
            user.setId(student.getId());
            user.setUserName(student.getUserName());
            user.setUserNo(student.getUserNo());
            user.setPassword(student.getPassword());
        }
        if(users.getRole().equals("教师")) //判断角色是否等于教师
        {

            Teacher teacher =teacherMapper.getByUserNo(users.getUserNo());//根据编号获取教师数据
            if(teacher==null){
                return RestFulBean.error("该教师用户不存在");
            }
            if(teacher.getChecked()==0){
                return RestFulBean.error("账号还未审核");
            }
            if(teacher.getChecked()==-1){
                return RestFulBean.error("账号审核不通过");
            }
            //赋值
            user.setId(teacher.getId());
            user.setUserName(teacher.getUserName());
            user.setUserNo(teacher.getUserNo());
            user.setPassword(teacher.getPassword());
        }
        if(users.getRole().equals("管理员")) //判断角色是否等于管理员
        {
            Manager manager =managerMapper.getByUserNo(users.getUserNo());//根据编号获取管理员数据
            if(manager==null){
                return RestFulBean.error("该管理员用户不存在");
            }
            if(manager.getChecked()==0){
                return RestFulBean.error("账号还未审核");
            }
            if(manager.getChecked()==-1){
                return RestFulBean.error("账号审核不通过");
            }
            //赋值
            user.setId(manager.getId());
            user.setUserName(manager.getUserName());
            user.setUserNo(manager.getUserNo());
            user.setPassword(manager.getPassword());
        }
            //判断密码跟数据库是否一样
            if(users.getPassword().equals(user.getPassword())){
                return RestFulBean.succ(user); //如果密码一样将用户对象放回到前端
            }
            else{
                return RestFulBean.error("密码错误");
            }
    }
}
