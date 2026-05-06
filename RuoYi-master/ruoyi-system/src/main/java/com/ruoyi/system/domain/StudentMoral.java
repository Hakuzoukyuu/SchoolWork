package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生德育考核管理对象 student_moral
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class StudentMoral extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生id */
    private String studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 所属班级ID */
    @Excel(name = "所属班级ID")
    private Long classId;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String className;

    /** 日常行为评分 */
    @Excel(name = "日常行为评分")
    private BigDecimal dailyScore;

    /** 文明校园考核分 */
    @Excel(name = "文明校园考核分")
    private BigDecimal campusScore;

    /** 德育总分 */
    @Excel(name = "德育总分")
    private BigDecimal totalScore;

    /** 考核状态(合格/不合格) */
    @Excel(name = "考核状态(合格/不合格)")
    private String examStatus;

    /** 考核日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "考核日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date examTime;

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

    public void setClassId(Long classId) 
    {
        this.classId = classId;
    }

    public Long getClassId() 
    {
        return classId;
    }

    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }

    public void setDailyScore(BigDecimal dailyScore) 
    {
        this.dailyScore = dailyScore;
    }

    public BigDecimal getDailyScore() 
    {
        return dailyScore;
    }

    public void setCampusScore(BigDecimal campusScore) 
    {
        this.campusScore = campusScore;
    }

    public BigDecimal getCampusScore() 
    {
        return campusScore;
    }

    public void setTotalScore(BigDecimal totalScore) 
    {
        this.totalScore = totalScore;
    }

    public BigDecimal getTotalScore() 
    {
        return totalScore;
    }

    public void setExamStatus(String examStatus) 
    {
        this.examStatus = examStatus;
    }

    public String getExamStatus() 
    {
        return examStatus;
    }

    public void setExamTime(Date examTime) 
    {
        this.examTime = examTime;
    }

    public Date getExamTime() 
    {
        return examTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("dailyScore", getDailyScore())
            .append("campusScore", getCampusScore())
            .append("totalScore", getTotalScore())
            .append("examStatus", getExamStatus())
            .append("examTime", getExamTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
