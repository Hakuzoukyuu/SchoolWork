package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 床位与学生入住子对象 dorm_bed
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class DormBed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 床位主键ID */
    private Long bedId;

    /** 关联所属宿舍ID */
    @Excel(name = "关联所属宿舍ID")
    private Long dormId;

    /** 床位编号 */
    @Excel(name = "床位编号")
    private String bedNo;

    /** 学生学号 */
    @Excel(name = "学生学号")
    private String studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 床位状态：空置/已入住/休学 */
    @Excel(name = "床位状态：空置/已入住/休学")
    private String bedStatus;

    /** 个人卫生情况 */
    @Excel(name = "个人卫生情况")
    private String dailyHygiene;

    /** 晚查寝状态 */
    @Excel(name = "晚查寝状态")
    private String nightCheck;

    /** 查寝时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "查寝时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    public void setBedId(Long bedId) 
    {
        this.bedId = bedId;
    }

    public Long getBedId() 
    {
        return bedId;
    }

    public void setDormId(Long dormId) 
    {
        this.dormId = dormId;
    }

    public Long getDormId() 
    {
        return dormId;
    }

    public void setBedNo(String bedNo) 
    {
        this.bedNo = bedNo;
    }

    public String getBedNo() 
    {
        return bedNo;
    }

    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
    }

    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }

    public void setBedStatus(String bedStatus) 
    {
        this.bedStatus = bedStatus;
    }

    public String getBedStatus() 
    {
        return bedStatus;
    }

    public void setDailyHygiene(String dailyHygiene) 
    {
        this.dailyHygiene = dailyHygiene;
    }

    public String getDailyHygiene() 
    {
        return dailyHygiene;
    }

    public void setNightCheck(String nightCheck) 
    {
        this.nightCheck = nightCheck;
    }

    public String getNightCheck() 
    {
        return nightCheck;
    }

    public void setCheckTime(Date checkTime) 
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() 
    {
        return checkTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bedId", getBedId())
            .append("dormId", getDormId())
            .append("bedNo", getBedNo())
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("bedStatus", getBedStatus())
            .append("dailyHygiene", getDailyHygiene())
            .append("nightCheck", getNightCheck())
            .append("checkTime", getCheckTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
