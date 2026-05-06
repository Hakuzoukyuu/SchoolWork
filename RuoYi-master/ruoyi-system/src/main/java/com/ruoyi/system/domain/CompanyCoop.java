package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 校企合作(父)对象 company_coop
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class CompanyCoop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 企业编号（主键/必填） */
    private String companyId;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String companyName;

    /** 企业地址 */
    @Excel(name = "企业地址")
    private String companyAddress;

    /** 企业联系人 */
    @Excel(name = "企业联系人")
    private String contactPerson;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 合作状态：合作中/已终止 */
    @Excel(name = "合作状态：合作中/已终止")
    private String coopStatus;

    /** 合作内容 */
    @Excel(name = "合作内容")
    private String coopContent;

    /** 企业实习(子)信息 */
    private List<StudentInternship> studentInternshipList;

    public void setCompanyId(String companyId) 
    {
        this.companyId = companyId;
    }

    public String getCompanyId() 
    {
        return companyId;
    }

    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }

    public void setCompanyAddress(String companyAddress) 
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() 
    {
        return companyAddress;
    }

    public void setContactPerson(String contactPerson) 
    {
        this.contactPerson = contactPerson;
    }

    public String getContactPerson() 
    {
        return contactPerson;
    }

    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() 
    {
        return contactPhone;
    }

    public void setCoopStatus(String coopStatus) 
    {
        this.coopStatus = coopStatus;
    }

    public String getCoopStatus() 
    {
        return coopStatus;
    }

    public void setCoopContent(String coopContent) 
    {
        this.coopContent = coopContent;
    }

    public String getCoopContent() 
    {
        return coopContent;
    }

    public List<StudentInternship> getStudentInternshipList()
    {
        return studentInternshipList;
    }

    public void setStudentInternshipList(List<StudentInternship> studentInternshipList)
    {
        this.studentInternshipList = studentInternshipList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("companyAddress", getCompanyAddress())
            .append("contactPerson", getContactPerson())
            .append("contactPhone", getContactPhone())
            .append("coopStatus", getCoopStatus())
            .append("coopContent", getCoopContent())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("studentInternshipList", getStudentInternshipList())
            .toString();
    }
}
