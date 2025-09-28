package com.design.machineManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Repairs)实体类
 *
 * @author makejava
 * @since 2024-07-29 09:35:29
 */
public class Repairs implements Serializable {
    private static final long serialVersionUID = -54094605188725097L;
     /**
     * 主键id
     */
    private Integer id;
     /**
     * 学号
     */
    private String userNo;
     /**
     * 学生id
     */
    private String studentId;
     /**
     * 姓名
     */
    private String userName;
     /**
     * 机房号
     */
    private String roomNo;
     /**
     * 故障照片
     */
    private String faultImages;
     /**
     * 上报日期
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 问题描述
     */
    private String descbs;
     /**
     * 维修照片
     */
    private String repairsImages;
     /**
     * 维修状态
     */
    private String status;
     /**
     * 学生确认
     */
    private String confirm;

    private Boolean disabled;
    private Integer count;
    private Integer year;
    private String month;
    private String yearMonth;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getFaultImages() {
        return faultImages;
    }

    public void setFaultImages(String faultImages) {
        this.faultImages = faultImages;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescbs() {
        return descbs;
    }

    public void setDescbs(String descbs) {
        this.descbs = descbs;
    }

    public String getRepairsImages() {
        return repairsImages;
    }

    public void setRepairsImages(String repairsImages) {
        this.repairsImages = repairsImages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

}

