package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生缴费对象 student_payment
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class StudentPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生编号（主键/必填） */
    private String studentId;

    /** 学生姓名（必填） */
    @Excel(name = "学生姓名", readConverterExp = "必=填")
    private String studentName;

    /** 所属专业 */
    @Excel(name = "所属专业")
    private String major;

    /** 学费 */
    @Excel(name = "学费")
    private BigDecimal tuitionFee;

    /** 住宿费 */
    @Excel(name = "住宿费")
    private BigDecimal dormFee;

    /** 杂费 */
    @Excel(name = "杂费")
    private BigDecimal otherFee;

    /** 代管费 */
    @Excel(name = "代管费")
    private BigDecimal managedFee;

    /** 应缴总金额 */
    @Excel(name = "应缴总金额")
    private BigDecimal totalFee;

    /** 已缴金额 */
    @Excel(name = "已缴金额")
    private BigDecimal paidFee;

    /** 欠费金额 */
    @Excel(name = "欠费金额")
    private BigDecimal unpaidFee;

    /** 缴费方式：线上/线下 */
    @Excel(name = "缴费方式：线上/线下")
    private String payType;

    /** 缴费状态 */
    @Excel(name = "缴费状态")
    private String payStatus;

    /** 缴费时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "缴费时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 缴费订单号 */
    @Excel(name = "缴费订单号")
    private String payOrderNo;

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

    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }

    public void setTuitionFee(BigDecimal tuitionFee) 
    {
        this.tuitionFee = tuitionFee;
    }

    public BigDecimal getTuitionFee() 
    {
        return tuitionFee;
    }

    public void setDormFee(BigDecimal dormFee) 
    {
        this.dormFee = dormFee;
    }

    public BigDecimal getDormFee() 
    {
        return dormFee;
    }

    public void setOtherFee(BigDecimal otherFee) 
    {
        this.otherFee = otherFee;
    }

    public BigDecimal getOtherFee() 
    {
        return otherFee;
    }

    public void setManagedFee(BigDecimal managedFee) 
    {
        this.managedFee = managedFee;
    }

    public BigDecimal getManagedFee() 
    {
        return managedFee;
    }

    public void setTotalFee(BigDecimal totalFee) 
    {
        this.totalFee = totalFee;
    }

    public BigDecimal getTotalFee() 
    {
        return totalFee;
    }

    public void setPaidFee(BigDecimal paidFee) 
    {
        this.paidFee = paidFee;
    }

    public BigDecimal getPaidFee() 
    {
        return paidFee;
    }

    public void setUnpaidFee(BigDecimal unpaidFee) 
    {
        this.unpaidFee = unpaidFee;
    }

    public BigDecimal getUnpaidFee() 
    {
        return unpaidFee;
    }

    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }

    public void setPayStatus(String payStatus) 
    {
        this.payStatus = payStatus;
    }

    public String getPayStatus() 
    {
        return payStatus;
    }

    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }

    public void setPayOrderNo(String payOrderNo) 
    {
        this.payOrderNo = payOrderNo;
    }

    public String getPayOrderNo() 
    {
        return payOrderNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("major", getMajor())
            .append("tuitionFee", getTuitionFee())
            .append("dormFee", getDormFee())
            .append("otherFee", getOtherFee())
            .append("managedFee", getManagedFee())
            .append("totalFee", getTotalFee())
            .append("paidFee", getPaidFee())
            .append("unpaidFee", getUnpaidFee())
            .append("payType", getPayType())
            .append("payStatus", getPayStatus())
            .append("payTime", getPayTime())
            .append("payOrderNo", getPayOrderNo())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
