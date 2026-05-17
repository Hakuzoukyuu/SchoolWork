package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教职工调动管理对象 staff_transfer
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class StaffTransfer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 异动记录ID */
    private Long transferId;

    /** 教职工编号 */
    @Excel(name = "教职工编号")
    private String staffId;

    /** 异动类型：入职/调岗/借调/离职/退休 */
    @Excel(name = "异动类型：入职/调岗/借调/离职/退休")
    private String transferType;

    /** 原部门 */
    @Excel(name = "原部门")
    private String oldDepartment;

    /** 新部门 */
    @Excel(name = "新部门")
    private String newDepartment;

    /** 异动时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "异动时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transferTime;

    /** 备注 */
    @Excel(name = "备注")
    private String transferRemark;

    public void setTransferId(Long transferId) 
    {
        this.transferId = transferId;
    }

    public Long getTransferId() 
    {
        return transferId;
    }

    public void setStaffId(String staffId) 
    {
        this.staffId = staffId;
    }

    public String getStaffId() 
    {
        return staffId;
    }

    public void setTransferType(String transferType) 
    {
        this.transferType = transferType;
    }

    public String getTransferType() 
    {
        return transferType;
    }

    public void setOldDepartment(String oldDepartment) 
    {
        this.oldDepartment = oldDepartment;
    }

    public String getOldDepartment() 
    {
        return oldDepartment;
    }

    public void setNewDepartment(String newDepartment) 
    {
        this.newDepartment = newDepartment;
    }

    public String getNewDepartment() 
    {
        return newDepartment;
    }

    public void setTransferTime(Date transferTime) 
    {
        this.transferTime = transferTime;
    }

    public Date getTransferTime() 
    {
        return transferTime;
    }

    public void setTransferRemark(String transferRemark) 
    {
        this.transferRemark = transferRemark;
    }

    public String getTransferRemark() 
    {
        return transferRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transferId", getTransferId())
            .append("staffId", getStaffId())
            .append("transferType", getTransferType())
            .append("oldDepartment", getOldDepartment())
            .append("newDepartment", getNewDepartment())
            .append("transferTime", getTransferTime())
            .append("transferRemark", getTransferRemark())
            .toString();
    }
}
