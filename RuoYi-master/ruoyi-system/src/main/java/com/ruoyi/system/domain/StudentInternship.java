package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 企业实习(子)对象 student_internship
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class StudentInternship extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实习编号（主键/必填） */
    private String internshipId;

    /** 学生编号（必填） */
    @Excel(name = "学生编号", readConverterExp = "必=填")
    private String studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 学生类型：本科生/研究生 */
    @Excel(name = "学生类型：本科生/研究生")
    private String studentType;

    /** 所属专业 */
    @Excel(name = "所属专业")
    private String major;

    /** 企业编号（外键/必填） */
    @Excel(name = "企业编号", readConverterExp = "外=键/必填")
    private String companyId;

    /** 实习岗位 */
    @Excel(name = "实习岗位")
    private String internshipPost;

    /** 实习开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "实习开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date internshipStart;

    /** 实习结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "实习结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date internshipEnd;

    /** 实习状态 */
    @Excel(name = "实习状态")
    private String internshipStatus;

    /** 实习报备状态 */
    @Excel(name = "实习报备状态")
    private String reportStatus;

    public void setInternshipId(String internshipId) 
    {
        this.internshipId = internshipId;
    }

    public String getInternshipId() 
    {
        return internshipId;
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
    public void setStudentType(String studentType) 
    {
        this.studentType = studentType;
    }

    public String getStudentType() 
    {
        return studentType;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setCompanyId(String companyId) 
    {
        this.companyId = companyId;
    }

    public String getCompanyId() 
    {
        return companyId;
    }
    public void setInternshipPost(String internshipPost) 
    {
        this.internshipPost = internshipPost;
    }

    public String getInternshipPost() 
    {
        return internshipPost;
    }
    public void setInternshipStart(Date internshipStart) 
    {
        this.internshipStart = internshipStart;
    }

    public Date getInternshipStart() 
    {
        return internshipStart;
    }
    public void setInternshipEnd(Date internshipEnd) 
    {
        this.internshipEnd = internshipEnd;
    }

    public Date getInternshipEnd() 
    {
        return internshipEnd;
    }
    public void setInternshipStatus(String internshipStatus) 
    {
        this.internshipStatus = internshipStatus;
    }

    public String getInternshipStatus() 
    {
        return internshipStatus;
    }
    public void setReportStatus(String reportStatus) 
    {
        this.reportStatus = reportStatus;
    }

    public String getReportStatus() 
    {
        return reportStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("internshipId", getInternshipId())
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("studentType", getStudentType())
            .append("major", getMajor())
            .append("companyId", getCompanyId())
            .append("internshipPost", getInternshipPost())
            .append("internshipStart", getInternshipStart())
            .append("internshipEnd", getInternshipEnd())
            .append("internshipStatus", getInternshipStatus())
            .append("reportStatus", getReportStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
