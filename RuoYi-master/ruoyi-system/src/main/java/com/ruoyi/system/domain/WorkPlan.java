package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 工作计划对象 work_plan
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class WorkPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 计划ID */
    private Long planId;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String deptName;

    /** 计划类型：周计划/月计划 */
    @Excel(name = "计划类型：周计划/月计划")
    private String planType;

    /** 计划周期：如2026年第17周/2026年4月 */
    @Excel(name = "计划周期：如2026年第17周/2026年4月")
    private String planPeriod;

    /** 工作计划内容 */
    @Excel(name = "工作计划内容")
    private String planContent;

    /** 工作总结内容 */
    @Excel(name = "工作总结内容")
    private String summaryContent;

    /** 提交人 */
    @Excel(name = "提交人")
    private String submitter;

    /** 提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submitTime;

    /** 状态：草稿/已提交/已审核 */
    @Excel(name = "状态：草稿/已提交/已审核")
    private String status;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String auditRemark;

    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }

    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }

    public void setPlanType(String planType) 
    {
        this.planType = planType;
    }

    public String getPlanType() 
    {
        return planType;
    }

    public void setPlanPeriod(String planPeriod) 
    {
        this.planPeriod = planPeriod;
    }

    public String getPlanPeriod() 
    {
        return planPeriod;
    }

    public void setPlanContent(String planContent) 
    {
        this.planContent = planContent;
    }

    public String getPlanContent() 
    {
        return planContent;
    }

    public void setSummaryContent(String summaryContent) 
    {
        this.summaryContent = summaryContent;
    }

    public String getSummaryContent() 
    {
        return summaryContent;
    }

    public void setSubmitter(String submitter) 
    {
        this.submitter = submitter;
    }

    public String getSubmitter() 
    {
        return submitter;
    }

    public void setSubmitTime(Date submitTime) 
    {
        this.submitTime = submitTime;
    }

    public Date getSubmitTime() 
    {
        return submitTime;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setAuditRemark(String auditRemark) 
    {
        this.auditRemark = auditRemark;
    }

    public String getAuditRemark() 
    {
        return auditRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planId", getPlanId())
            .append("deptName", getDeptName())
            .append("planType", getPlanType())
            .append("planPeriod", getPlanPeriod())
            .append("planContent", getPlanContent())
            .append("summaryContent", getSummaryContent())
            .append("submitter", getSubmitter())
            .append("submitTime", getSubmitTime())
            .append("status", getStatus())
            .append("auditRemark", getAuditRemark())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
