package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维修报修对象 repair_report
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class RepairReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 报修位置 */
    @Excel(name = "报修位置")
    private String repairLocation;

    /** 报修内容 */
    @Excel(name = "报修内容")
    private String repairContent;

    /** 报修人 */
    @Excel(name = "报修人")
    private String reportPeople;

    /** 报修时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "报修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportTime;

    /** 派单处理人 */
    @Excel(name = "派单处理人")
    private String assignPeople;

    /** 维修状态：待派单/处理中/已完成 */
    @Excel(name = "维修状态：待派单/处理中/已完成")
    private String repairStatus;

    /** 验收状态：未验收/已验收 */
    @Excel(name = "验收状态：未验收/已验收")
    private String checkStatus;

    /** 维修完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "维修完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date repairTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setRepairLocation(String repairLocation) 
    {
        this.repairLocation = repairLocation;
    }

    public String getRepairLocation() 
    {
        return repairLocation;
    }

    public void setRepairContent(String repairContent) 
    {
        this.repairContent = repairContent;
    }

    public String getRepairContent() 
    {
        return repairContent;
    }

    public void setReportPeople(String reportPeople) 
    {
        this.reportPeople = reportPeople;
    }

    public String getReportPeople() 
    {
        return reportPeople;
    }

    public void setReportTime(Date reportTime) 
    {
        this.reportTime = reportTime;
    }

    public Date getReportTime() 
    {
        return reportTime;
    }

    public void setAssignPeople(String assignPeople) 
    {
        this.assignPeople = assignPeople;
    }

    public String getAssignPeople() 
    {
        return assignPeople;
    }

    public void setRepairStatus(String repairStatus) 
    {
        this.repairStatus = repairStatus;
    }

    public String getRepairStatus() 
    {
        return repairStatus;
    }

    public void setCheckStatus(String checkStatus) 
    {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus() 
    {
        return checkStatus;
    }

    public void setRepairTime(Date repairTime) 
    {
        this.repairTime = repairTime;
    }

    public Date getRepairTime() 
    {
        return repairTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("repairLocation", getRepairLocation())
            .append("repairContent", getRepairContent())
            .append("reportPeople", getReportPeople())
            .append("reportTime", getReportTime())
            .append("assignPeople", getAssignPeople())
            .append("repairStatus", getRepairStatus())
            .append("checkStatus", getCheckStatus())
            .append("repairTime", getRepairTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
