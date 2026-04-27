package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学籍信息对象 student_academic
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
public class StudentAcademic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学籍主键 */
    private Long academicId;

    /** 关联学生ID */
    @Excel(name = "关联学生ID")
    private Long studentId;

    /** 院系/学部 */
    @Excel(name = "院系/学部")
    private String college;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 班级 */
    @Excel(name = "班级")
    private String className;

    /** 学制 */
    @Excel(name = "学制")
    private String studyLength;

    /** 学生证号 */
    @Excel(name = "学生证号")
    private String studentCardNo;

    /** 学籍状态（正常、休学、退学、毕业） */
    @Excel(name = "学籍状态", readConverterExp = "正=常、休学、退学、毕业")
    private String studentStatus;

    /** 入学日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "入学日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date comeDate;

    /** 预计毕业日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "预计毕业日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date graduateDate;

    public void setAcademicId(Long academicId) 
    {
        this.academicId = academicId;
    }

    public Long getAcademicId() 
    {
        return academicId;
    }

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setCollege(String college) 
    {
        this.college = college;
    }

    public String getCollege() 
    {
        return college;
    }

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }

    public void setGrade(String grade) 
    {
        this.grade = grade;
    }

    public String getGrade() 
    {
        return grade;
    }

    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }

    public void setStudyLength(String studyLength) 
    {
        this.studyLength = studyLength;
    }

    public String getStudyLength() 
    {
        return studyLength;
    }

    public void setStudentCardNo(String studentCardNo) 
    {
        this.studentCardNo = studentCardNo;
    }

    public String getStudentCardNo() 
    {
        return studentCardNo;
    }

    public void setStudentStatus(String studentStatus) 
    {
        this.studentStatus = studentStatus;
    }

    public String getStudentStatus() 
    {
        return studentStatus;
    }

    public void setComeDate(Date comeDate) 
    {
        this.comeDate = comeDate;
    }

    public Date getComeDate() 
    {
        return comeDate;
    }

    public void setGraduateDate(Date graduateDate) 
    {
        this.graduateDate = graduateDate;
    }

    public Date getGraduateDate() 
    {
        return graduateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("academicId", getAcademicId())
            .append("studentId", getStudentId())
            .append("college", getCollege())
            .append("major", getMajor())
            .append("grade", getGrade())
            .append("className", getClassName())
            .append("studyLength", getStudyLength())
            .append("studentCardNo", getStudentCardNo())
            .append("studentStatus", getStudentStatus())
            .append("comeDate", getComeDate())
            .append("graduateDate", getGraduateDate())
            .toString();
    }
}
