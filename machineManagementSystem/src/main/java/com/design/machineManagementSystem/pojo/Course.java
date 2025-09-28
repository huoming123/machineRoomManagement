package com.design.machineManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2024-07-28 15:13:45
 */
public class Course implements Serializable {
    private static final long serialVersionUID = -50967383222278005L;
     /**
     * 主键id 自增id
     */
    private Integer id;
     /**
     * 课程名称
     */
    private String courseName;
     /**
     * 创建时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 创建人
     */
    private String createdBy;
     /**
     * 课时
     */
    private Integer hours;
     /**
     * 管理员id
     */
    private Integer managerId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

}

