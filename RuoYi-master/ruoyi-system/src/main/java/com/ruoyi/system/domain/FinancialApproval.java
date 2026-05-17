package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 财务审批对象 financial_approval
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class FinancialApproval extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 财务审批ID（主键/必填） */
    private Long financialId;

    /** 审批类型：费用报销/物资采购（必填） */
    @Excel(name = "审批类型：费用报销/物资采购", readConverterExp = "必=填")
    private String approvalType;

    /** 审批标题/台账名称 */
    @Excel(name = "审批标题/台账名称")
    private String approvalTitle;

    /** 申请人 */
    @Excel(name = "申请人")
    private String applyUser;

    /** 申请部门 */
    @Excel(name = "申请部门")
    private String applyDept;

    /** 申请金额（必填） */
    @Excel(name = "申请金额", readConverterExp = "必=填")
    private BigDecimal feeAmount;

    /** 审批状态：待审批/已通过/已驳回（必填） */
    @Excel(name = "审批状态：待审批/已通过/已驳回", readConverterExp = "必=填")
    private String approvalStatus;

    /** 审批人 */
    @Excel(name = "审批人")
    private String approvalUser;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date approvalTime;

    /** 财务台账记录 */
    @Excel(name = "财务台账记录")
    private String accountRecord;

    public void setFinancialId(Long financialId) 
    {
        this.financialId = financialId;
    }

    public Long getFinancialId() 
    {
        return financialId;
    }

    public void setApprovalType(String approvalType) 
    {
        this.approvalType = approvalType;
    }

    public String getApprovalType() 
    {
        return approvalType;
    }

    public void setApprovalTitle(String approvalTitle) 
    {
        this.approvalTitle = approvalTitle;
    }

    public String getApprovalTitle() 
    {
        return approvalTitle;
    }

    public void setApplyUser(String applyUser) 
    {
        this.applyUser = applyUser;
    }

    public String getApplyUser() 
    {
        return applyUser;
    }

    public void setApplyDept(String applyDept) 
    {
        this.applyDept = applyDept;
    }

    public String getApplyDept() 
    {
        return applyDept;
    }

    public void setFeeAmount(BigDecimal feeAmount) 
    {
        this.feeAmount = feeAmount;
    }

    public BigDecimal getFeeAmount() 
    {
        return feeAmount;
    }

    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
    }

    public void setApprovalUser(String approvalUser) 
    {
        this.approvalUser = approvalUser;
    }

    public String getApprovalUser() 
    {
        return approvalUser;
    }

    public void setApprovalTime(Date approvalTime) 
    {
        this.approvalTime = approvalTime;
    }

    public Date getApprovalTime() 
    {
        return approvalTime;
    }

    public void setAccountRecord(String accountRecord) 
    {
        this.accountRecord = accountRecord;
    }

    public String getAccountRecord() 
    {
        return accountRecord;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("financialId", getFinancialId())
            .append("approvalType", getApprovalType())
            .append("approvalTitle", getApprovalTitle())
            .append("applyUser", getApplyUser())
            .append("applyDept", getApplyDept())
            .append("feeAmount", getFeeAmount())
            .append("approvalStatus", getApprovalStatus())
            .append("approvalUser", getApprovalUser())
            .append("approvalTime", getApprovalTime())
            .append("accountRecord", getAccountRecord())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
