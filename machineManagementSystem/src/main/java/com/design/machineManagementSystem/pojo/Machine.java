package com.design.machineManagementSystem.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Machine)实体类
 *
 * @author makejava
 * @since 2024-07-28 16:20:14
 */
public class Machine implements Serializable {
    private static final long serialVersionUID = -37533097130748708L;
     /**
     * 主键 自增id
     */
    private Integer id;
     /**
     * 机房号
     */
    private String roomNo;
     /**
     * 容纳人数
     */
    private Integer num;
     /**
     * 机房介绍
     */
    private String describ;
     /**
     * 机房照片
     */
    private String image;
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
     * 管理员id
     */
    private Integer managerId;


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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

}

