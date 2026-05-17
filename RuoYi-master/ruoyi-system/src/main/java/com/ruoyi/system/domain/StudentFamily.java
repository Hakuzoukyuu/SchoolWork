package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 家庭信息对象 student_family
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
public class StudentFamily extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 家庭主键 */
    private Long familyId;

    /** 关联学生ID */
    @Excel(name = "关联学生ID")
    private Long studentId;

    /** 家长姓名 */
    @Excel(name = "家长姓名")
    private String parentName;

    /** 与学生关系 */
    @Excel(name = "与学生关系")
    private String parentRelation;

    /** 家长职业 */
    @Excel(name = "家长职业")
    private String parentJob;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String familyAddress;

    /** 家庭经济情况（贫困、一般、良好） */
    @Excel(name = "家庭经济情况", readConverterExp = "贫=困、一般、良好")
    private String familyIncome;

    /** 家庭固定电话 */
    @Excel(name = "家庭固定电话")
    private String familyPhone;

    public void setFamilyId(Long familyId) 
    {
        this.familyId = familyId;
    }

    public Long getFamilyId() 
    {
        return familyId;
    }

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setParentName(String parentName) 
    {
        this.parentName = parentName;
    }

    public String getParentName() 
    {
        return parentName;
    }

    public void setParentRelation(String parentRelation) 
    {
        this.parentRelation = parentRelation;
    }

    public String getParentRelation() 
    {
        return parentRelation;
    }

    public void setParentJob(String parentJob) 
    {
        this.parentJob = parentJob;
    }

    public String getParentJob() 
    {
        return parentJob;
    }

    public void setFamilyAddress(String familyAddress) 
    {
        this.familyAddress = familyAddress;
    }

    public String getFamilyAddress() 
    {
        return familyAddress;
    }

    public void setFamilyIncome(String familyIncome) 
    {
        this.familyIncome = familyIncome;
    }

    public String getFamilyIncome() 
    {
        return familyIncome;
    }

    public void setFamilyPhone(String familyPhone) 
    {
        this.familyPhone = familyPhone;
    }

    public String getFamilyPhone() 
    {
        return familyPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("familyId", getFamilyId())
            .append("studentId", getStudentId())
            .append("parentName", getParentName())
            .append("parentRelation", getParentRelation())
            .append("parentJob", getParentJob())
            .append("familyAddress", getFamilyAddress())
            .append("familyIncome", getFamilyIncome())
            .append("familyPhone", getFamilyPhone())
            .toString();
    }
}
