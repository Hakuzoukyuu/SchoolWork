package com.ruoyi.StudentManagement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息对象 student_info
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
public class StudentInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生学号 */
    private Long studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 学生性别 */
    @Excel(name = "学生性别")
    private String gender;

    /** 学院编号 */
    @Excel(name = "学院编号")
    private Long collegeId;

    /** 学生专业 */
    @Excel(name = "学生专业")
    private String major;

    /** 学生班级 */
    @Excel(name = "学生班级")
    private String className;

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
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

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setCollegeId(Long collegeId) 
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId() 
    {
        return collegeId;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }

    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("gender", getGender())
            .append("collegeId", getCollegeId())
            .append("major", getMajor())
            .append("className", getClassName())
            .toString();
    }
}
