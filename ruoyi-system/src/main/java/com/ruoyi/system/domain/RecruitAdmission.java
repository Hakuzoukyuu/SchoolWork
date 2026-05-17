package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 招生管理(志愿通过-未正式录取学生)对象 recruit_admission
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class RecruitAdmission extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 学生编号（必填） */
    @Excel(name = "学生编号", readConverterExp = "必=填")
    private String studentId;

    /** 学生姓名（必填） */
    @Excel(name = "学生姓名", readConverterExp = "必=填")
    private String studentName;

    /** 学生类型：本科生/研究生（必填） */
    @Excel(name = "学生类型：本科生/研究生", readConverterExp = "必=填")
    private String studentType;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 报考专业 */
    @Excel(name = "报考专业")
    private String applyMajor;

    /** 志愿审核状态：已通过 */
    @Excel(name = "志愿审核状态：已通过")
    private String auditStatus;

    /** 录取状态：未录取（核心用途） */
    @Excel(name = "录取状态：未录取", readConverterExp = "核=心用途")
    private String admitStatus;

    /** 拟录取分班 */
    @Excel(name = "拟录取分班")
    private String className;

    /** 预注册状态 */
    @Excel(name = "预注册状态")
    private String preRegisterStatus;

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

    public void setStudentType(String studentType) 
    {
        this.studentType = studentType;
    }

    public String getStudentType() 
    {
        return studentType;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }

    public void setApplyMajor(String applyMajor) 
    {
        this.applyMajor = applyMajor;
    }

    public String getApplyMajor() 
    {
        return applyMajor;
    }

    public void setAuditStatus(String auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus() 
    {
        return auditStatus;
    }

    public void setAdmitStatus(String admitStatus) 
    {
        this.admitStatus = admitStatus;
    }

    public String getAdmitStatus() 
    {
        return admitStatus;
    }

    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }

    public void setPreRegisterStatus(String preRegisterStatus) 
    {
        this.preRegisterStatus = preRegisterStatus;
    }

    public String getPreRegisterStatus() 
    {
        return preRegisterStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("studentType", getStudentType())
            .append("phone", getPhone())
            .append("idCard", getIdCard())
            .append("applyMajor", getApplyMajor())
            .append("auditStatus", getAuditStatus())
            .append("admitStatus", getAdmitStatus())
            .append("className", getClassName())
            .append("preRegisterStatus", getPreRegisterStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
