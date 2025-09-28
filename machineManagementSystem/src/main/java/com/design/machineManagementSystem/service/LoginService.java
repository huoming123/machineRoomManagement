package com.design.machineManagementSystem.service;

import com.design.machineManagementSystem.pojo.Users;
import com.design.machineManagementSystem.pojo.res.RestFulBean;

import java.util.Map;

public interface LoginService {

    RestFulBean<Users> login(Users users) throws Exception;
}
