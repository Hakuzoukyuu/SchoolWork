package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 住宿信息对象 student_dorm
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
public class StudentDorm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 住宿主键 */
    private Long dormId;

    /** 关联学生ID */
    @Excel(name = "关联学生ID")
    private Long studentId;

    /** 宿舍号 */
    @Excel(name = "宿舍号")
    private String dormNo;

    /** 床位号 */
    @Excel(name = "床位号")
    private String bedNo;

    /** 辅导员 */
    @Excel(name = "辅导员")
    private String counselor;

    /** 班主任 */
    @Excel(name = "班主任")
    private String teacher;

    /** 在校状态（在校、走读、外宿） */
    @Excel(name = "在校状态", readConverterExp = "在=校、走读、外宿")
    private String schoolStatus;

    public void setDormId(Long dormId) 
    {
        this.dormId = dormId;
    }

    public Long getDormId() 
    {
        return dormId;
    }

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setDormNo(String dormNo) 
    {
        this.dormNo = dormNo;
    }

    public String getDormNo() 
    {
        return dormNo;
    }

    public void setBedNo(String bedNo) 
    {
        this.bedNo = bedNo;
    }

    public String getBedNo() 
    {
        return bedNo;
    }

    public void setCounselor(String counselor) 
    {
        this.counselor = counselor;
    }

    public String getCounselor() 
    {
        return counselor;
    }

    public void setTeacher(String teacher) 
    {
        this.teacher = teacher;
    }

    public String getTeacher() 
    {
        return teacher;
    }

    public void setSchoolStatus(String schoolStatus) 
    {
        this.schoolStatus = schoolStatus;
    }

    public String getSchoolStatus() 
    {
        return schoolStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dormId", getDormId())
            .append("studentId", getStudentId())
            .append("dormNo", getDormNo())
            .append("bedNo", getBedNo())
            .append("counselor", getCounselor())
            .append("teacher", getTeacher())
            .append("schoolStatus", getSchoolStatus())
            .toString();
    }
}
