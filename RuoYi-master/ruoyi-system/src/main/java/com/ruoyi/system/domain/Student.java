package com.ruoyi.system.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生对象 student
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
public class Student extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生主键ID（唯一非空） */
    private Long studentId;

    /** 学号（唯一） */
    @Excel(name = "学号", readConverterExp = "唯=一")
    private String studentNo;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 性别（男/女） */
    @Excel(name = "性别", readConverterExp = "男=/女")
    private String gender;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthDate;

    /** 身份证号（唯一） */
    @Excel(name = "身份证号", readConverterExp = "唯=一")
    private String idCard;

    /** 民族 */
    @Excel(name = "民族")
    private String ethnic;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String political;

    /** 血型 */
    @Excel(name = "血型")
    private String bloodType;

    /** 身高(cm) */
    @Excel(name = "身高(cm)")
    private Long height;

    /** 体重(kg) */
    @Excel(name = "体重(kg)")
    private Long weight;

    /** 学生手机号 */
    @Excel(name = "学生手机号")
    private String phone;

    /** 家长/监护人手机号 */
    @Excel(name = "家长/监护人手机号")
    private String parentPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechat;

    /** QQ号 */
    @Excel(name = "QQ号")
    private String qq;

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }

    public void setStudentNo(String studentNo) 
    {
        this.studentNo = studentNo;
    }

    public String getStudentNo() 
    {
        return studentNo;
    }

    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setBirthDate(Date birthDate) 
    {
        this.birthDate = birthDate;
    }

    public Date getBirthDate() 
    {
        return birthDate;
    }

    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }

    public void setEthnic(String ethnic) 
    {
        this.ethnic = ethnic;
    }

    public String getEthnic() 
    {
        return ethnic;
    }

    public void setPolitical(String political) 
    {
        this.political = political;
    }

    public String getPolitical() 
    {
        return political;
    }

    public void setBloodType(String bloodType) 
    {
        this.bloodType = bloodType;
    }

    public String getBloodType() 
    {
        return bloodType;
    }

    public void setHeight(Long height) 
    {
        this.height = height;
    }

    public Long getHeight() 
    {
        return height;
    }

    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setParentPhone(String parentPhone) 
    {
        this.parentPhone = parentPhone;
    }

    public String getParentPhone() 
    {
        return parentPhone;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setWechat(String wechat) 
    {
        this.wechat = wechat;
    }

    public String getWechat() 
    {
        return wechat;
    }

    public void setQq(String qq) 
    {
        this.qq = qq;
    }

    public String getQq() 
    {
        return qq;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("studentNo", getStudentNo())
            .append("studentName", getStudentName())
            .append("gender", getGender())
            .append("birthDate", getBirthDate())
            .append("idCard", getIdCard())
            .append("ethnic", getEthnic())
            .append("political", getPolitical())
            .append("bloodType", getBloodType())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("phone", getPhone())
            .append("parentPhone", getParentPhone())
            .append("email", getEmail())
            .append("wechat", getWechat())
            .append("qq", getQq())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
