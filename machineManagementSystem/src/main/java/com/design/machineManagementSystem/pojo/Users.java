package com.design.machineManagementSystem.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 664501981214946946L;
    /**
     * 主键 自增id
     */
    private Integer id;
    /**
     * 教师名字
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Timestamp createdAt;
    /**
     * 修改时间
     */
    private Timestamp updatedAt;
    /**

     */
    private String userNo;
    /**
     * 角色
     */
    private String role;
    /**
     * 性别

     */
    private String sex;
    /**
     * 职称
     */
    private String rank;
    /**
     * 科系
     */
    private String department;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 照片
     */
    private String image;
    /**
     * 照片路劲 用于前端显示
     */
    private String imageUrl;
    /**
     * 修改人
     */
    private String updatedBy;
    /**
     * 创建人
     */
    private String createdBy;
    private String oldPassword;
    private String newsPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewsPassword() {
        return newsPassword;
    }

    public void setNewsPassword(String newsPassword) {
        this.newsPassword = newsPassword;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
