package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生心理健康对象 student_mental
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class StudentMental extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 心理档案ID */
    private Long id;

    /** 学生编号 */
    @Excel(name = "学生编号")
    private String studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 班级 */
    @Excel(name = "班级")
    private String className;

    /** 心理档案 */
    @Excel(name = "心理档案")
    private String mentalFile;

    /** 咨询预约状态 */
    @Excel(name = "咨询预约状态")
    private String appointStatus;

    /** 预约时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appointTime;

    /** 心理普查结果 */
    @Excel(name = "心理普查结果")
    private String surveyResult;

    /** 危机干预状态 */
    @Excel(name = "危机干预状态")
    private String crisisStatus;

    /** 干预处理记录 */
    @Excel(name = "干预处理记录")
    private String handleRecord;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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

    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }

    public void setMentalFile(String mentalFile) 
    {
        this.mentalFile = mentalFile;
    }

    public String getMentalFile() 
    {
        return mentalFile;
    }

    public void setAppointStatus(String appointStatus) 
    {
        this.appointStatus = appointStatus;
    }

    public String getAppointStatus() 
    {
        return appointStatus;
    }

    public void setAppointTime(Date appointTime) 
    {
        this.appointTime = appointTime;
    }

    public Date getAppointTime() 
    {
        return appointTime;
    }

    public void setSurveyResult(String surveyResult) 
    {
        this.surveyResult = surveyResult;
    }

    public String getSurveyResult() 
    {
        return surveyResult;
    }

    public void setCrisisStatus(String crisisStatus) 
    {
        this.crisisStatus = crisisStatus;
    }

    public String getCrisisStatus() 
    {
        return crisisStatus;
    }

    public void setHandleRecord(String handleRecord) 
    {
        this.handleRecord = handleRecord;
    }

    public String getHandleRecord() 
    {
        return handleRecord;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("className", getClassName())
            .append("mentalFile", getMentalFile())
            .append("appointStatus", getAppointStatus())
            .append("appointTime", getAppointTime())
            .append("surveyResult", getSurveyResult())
            .append("crisisStatus", getCrisisStatus())
            .append("handleRecord", getHandleRecord())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
