package com.ruoyi.StudentManagement.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生住宿信息对象 student_accommodation
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
public class StudentAccommodation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 住宿记录ID */
    private Long accommodationId;

    /** 学生学号 */
    @Excel(name = "学生学号")
    private Long studentId;

    /** 宿舍楼号 */
    @Excel(name = "宿舍楼号")
    private String buildingNo;

    /** 楼层 */
    @Excel(name = "楼层")
    private String floor;

    /** 门牌号 */
    @Excel(name = "门牌号")
    private String roomNo;

    /** 入住日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "入住日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkInDate;

    /** 退宿日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "退宿日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkOutDate;

    /** 住宿状态 */
    @Excel(name = "住宿状态")
    private String status;

    public void setAccommodationId(Long accommodationId) 
    {
        this.accommodationId = accommodationId;
    }

    public Long getAccommodationId() 
    {
        return accommodationId;
    }

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setBuildingNo(String buildingNo) 
    {
        this.buildingNo = buildingNo;
    }

    public String getBuildingNo() 
    {
        return buildingNo;
    }

    public void setFloor(String floor) 
    {
        this.floor = floor;
    }

    public String getFloor() 
    {
        return floor;
    }

    public void setRoomNo(String roomNo) 
    {
        this.roomNo = roomNo;
    }

    public String getRoomNo() 
    {
        return roomNo;
    }

    public void setCheckInDate(Date checkInDate) 
    {
        this.checkInDate = checkInDate;
    }

    public Date getCheckInDate() 
    {
        return checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) 
    {
        this.checkOutDate = checkOutDate;
    }

    public Date getCheckOutDate() 
    {
        return checkOutDate;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("accommodationId", getAccommodationId())
            .append("studentId", getStudentId())
            .append("buildingNo", getBuildingNo())
            .append("floor", getFloor())
            .append("roomNo", getRoomNo())
            .append("checkInDate", getCheckInDate())
            .append("checkOutDate", getCheckOutDate())
            .append("status", getStatus())
            .toString();
    }
}
