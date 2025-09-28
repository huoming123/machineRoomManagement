package com.design.machineManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Borrow)实体类
 *
 * @author makejava
 * @since 2024-07-28 20:10:46
 */
public class Borrow implements Serializable {
    private static final long serialVersionUID = 582478318735004255L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 机房号
     */
    private String roomNo;
     /**
     * 学生id
     */
    private Integer studentId;
     /**
     * 审核 1为通过 0 为作废
     */
    private Integer checked;
     /**
     * 开始时间
     */
    private String startTime;
     /**
     * 结束时间
     */
    private String endTime;
     /**
     * 理由
     */
    private String reason;
     /**
     * 使用时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date classTime;
     /**
     * 申请时间
     */
     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm", timezone = "GMT+8")
     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createdAt;
     /**
     * 申请人
     */
    private String createdBy;
     /**
     * 教师id
     */
    private Integer teacherId;

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

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

}

