package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 班级管理对象 class_management
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class ClassManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 班级ID(主键，数字型 1/2/3) */
    private Long classId;

    /** 班级名称(如：2201班/研2302班) */
    @Excel(name = "班级名称(如：2201班/研2302班)")
    private String className;

    /** 年级(本科/研究生) */
    @Excel(name = "年级(本科/研究生)")
    private String grade;

    /** 班主任姓名 */
    @Excel(name = "班主任姓名")
    private String teacherName;

    /** 班级量化考核分数 */
    @Excel(name = "班级量化考核分数")
    private BigDecimal examScore;

    /** 班风评比等级(优秀/良好/合格) */
    @Excel(name = "班风评比等级(优秀/良好/合格)")
    private String classLevel;

    /** 班主任工作记录 */
    @Excel(name = "班主任工作记录")
    private String workRecord;

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

    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }

    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }

    public void setExamScore(BigDecimal examScore) 
    {
        this.examScore = examScore;
    }

    public BigDecimal getExamScore() 
    {
        return examScore;
    }

    public void setClassLevel(String classLevel) 
    {
        this.classLevel = classLevel;
    }

    public String getClassLevel() 
    {
        return classLevel;
    }

    public void setWorkRecord(String workRecord) 
    {
        this.workRecord = workRecord;
    }

    public String getWorkRecord() 
    {
        return workRecord;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("classId", getClassId())
            .append("className", getClassName())
            .append("grade", getGrade())
            .append("teacherName", getTeacherName())
            .append("examScore", getExamScore())
            .append("classLevel", getClassLevel())
            .append("workRecord", getWorkRecord())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
