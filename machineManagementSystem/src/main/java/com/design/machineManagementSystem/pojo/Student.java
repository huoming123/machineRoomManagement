package com.design.machineManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2024-07-27 19:38:39
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 378064270685216981L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 学生编号
     */
    private String userNo;
     /**
     * 学生名字
     */
    private String userName;
     /**
     * 注册时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 性别
     */
    private String sex;
     /**
     * 班级
     */
    private String classess;
     /**
     * 照片
     */
    private String image;
     /**
     * 专业
     */
    private String professional;
     /**
     * 院系
     */
    private String department;
     /**
     * 注册人
     */
    private String createdBy;
     /**
     * 审核
     */
    private Integer checked;
     /**
     * 密码
     */
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClassess() {
        return classess;
    }

    public void setClassess(String classess) {
        this.classess = classess;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

