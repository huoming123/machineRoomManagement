package com.design.machineManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (ScheduleClass)实体类
 *
 * @author makejava
 * @since 2024-07-28 17:19:19
 */
public class ScheduleClass implements Serializable {
    private static final long serialVersionUID = 151390395791432725L;
     
    private Integer id;
     /**
     * 课程名称
     */
    private String courseName;
     /**
     * 教师id
     */
    private Integer teacherId;
     /**
     * 开始时间
     */
    private String startTime;
     /**
     * 结束时间
     */
    private String endTime;
     /**
     * 机房号
     */
    private String roomNo;
     /**
     * 创建日期
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 创建人
     */
    private String createdBy;
     /**
     * 周几
     */
    private String weekDay;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
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

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

}

