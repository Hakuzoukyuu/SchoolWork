package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 staff_attendance
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class StaffAttendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考勤记录ID */
    private Long attenId;

    /** 教职工编号 */
    @Excel(name = "教职工编号")
    private String staffId;

    /** 排班日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "排班日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dutyDate;

    /** 值班类型/班次 */
    @Excel(name = "值班类型/班次")
    private String dutyType;

    /** 打卡状态：正常/迟到/早退/缺勤 */
    @Excel(name = "打卡状态：正常/迟到/早退/缺勤")
    private String clockStatus;

    /** 请假类型：事假/病假/调休 */
    @Excel(name = "请假类型：事假/病假/调休")
    private String leaveType;

    /** 加班时长 */
    @Excel(name = "加班时长")
    private BigDecimal overtimeHours;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String auditStatus;

    public void setAttenId(Long attenId) 
    {
        this.attenId = attenId;
    }

    public Long getAttenId() 
    {
        return attenId;
    }

    public void setStaffId(String staffId) 
    {
        this.staffId = staffId;
    }

    public String getStaffId() 
    {
        return staffId;
    }

    public void setDutyDate(Date dutyDate) 
    {
        this.dutyDate = dutyDate;
    }

    public Date getDutyDate() 
    {
        return dutyDate;
    }

    public void setDutyType(String dutyType) 
    {
        this.dutyType = dutyType;
    }

    public String getDutyType() 
    {
        return dutyType;
    }

    public void setClockStatus(String clockStatus) 
    {
        this.clockStatus = clockStatus;
    }

    public String getClockStatus() 
    {
        return clockStatus;
    }

    public void setLeaveType(String leaveType) 
    {
        this.leaveType = leaveType;
    }

    public String getLeaveType() 
    {
        return leaveType;
    }

    public void setOvertimeHours(BigDecimal overtimeHours) 
    {
        this.overtimeHours = overtimeHours;
    }

    public BigDecimal getOvertimeHours() 
    {
        return overtimeHours;
    }

    public void setAuditStatus(String auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus() 
    {
        return auditStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attenId", getAttenId())
            .append("staffId", getStaffId())
            .append("dutyDate", getDutyDate())
            .append("dutyType", getDutyType())
            .append("clockStatus", getClockStatus())
            .append("leaveType", getLeaveType())
            .append("overtimeHours", getOvertimeHours())
            .append("auditStatus", getAuditStatus())
            .toString();
    }
}
