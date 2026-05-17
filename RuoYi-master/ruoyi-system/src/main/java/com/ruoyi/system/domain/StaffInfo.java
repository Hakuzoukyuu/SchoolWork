package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教职工基础档案主对象 staff_info
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class StaffInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教职工编号(唯一主键) */
    private String staffId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String staffName;

    /** 人员类型：教师/行政/后勤 */
    @Excel(name = "人员类型：教师/行政/后勤")
    private String staffType;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String department;

    /** 职称 */
    @Excel(name = "职称")
    private String jobTitle;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 合同类型 */
    @Excel(name = "合同类型")
    private String contractType;

    /** 合同开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "合同开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractStart;

    /** 合同到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "合同到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractEnd;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 在职状态：在岗/借调/离职/退休 */
    @Excel(name = "在职状态：在岗/借调/离职/退休")
    private String staffStatus;

    public void setStaffId(String staffId) 
    {
        this.staffId = staffId;
    }

    public String getStaffId() 
    {
        return staffId;
    }

    public void setStaffName(String staffName) 
    {
        this.staffName = staffName;
    }

    public String getStaffName() 
    {
        return staffName;
    }

    public void setStaffType(String staffType) 
    {
        this.staffType = staffType;
    }

    public String getStaffType() 
    {
        return staffType;
    }

    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }

    public void setJobTitle(String jobTitle) 
    {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() 
    {
        return jobTitle;
    }

    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }

    public void setContractType(String contractType) 
    {
        this.contractType = contractType;
    }

    public String getContractType() 
    {
        return contractType;
    }

    public void setContractStart(Date contractStart) 
    {
        this.contractStart = contractStart;
    }

    public Date getContractStart() 
    {
        return contractStart;
    }

    public void setContractEnd(Date contractEnd) 
    {
        this.contractEnd = contractEnd;
    }

    public Date getContractEnd() 
    {
        return contractEnd;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setStaffStatus(String staffStatus) 
    {
        this.staffStatus = staffStatus;
    }

    public String getStaffStatus() 
    {
        return staffStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("staffId", getStaffId())
            .append("staffName", getStaffName())
            .append("staffType", getStaffType())
            .append("department", getDepartment())
            .append("jobTitle", getJobTitle())
            .append("education", getEducation())
            .append("contractType", getContractType())
            .append("contractStart", getContractStart())
            .append("contractEnd", getContractEnd())
            .append("phone", getPhone())
            .append("staffStatus", getStaffStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
