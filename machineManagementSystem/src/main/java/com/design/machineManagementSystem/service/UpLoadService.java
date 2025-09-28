package com.design.machineManagementSystem.service;

import com.design.machineManagementSystem.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UpLoadService {
    RestFulBean<Map> upload(MultipartFile coverFile);
}
