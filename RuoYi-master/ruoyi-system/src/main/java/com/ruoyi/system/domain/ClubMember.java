package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社团成员表对象 club_member
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class ClubMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成员ID(主键) */
    private Long memberId;

    /** 社团ID(外键关联club表) */
    @Excel(name = "社团ID(外键关联club表)")
    private Long clubId;

    /** 学生编号 */
    @Excel(name = "学生编号")
    private String studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 加入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "加入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date joinTime;

    /** 成员身份(成员/干部) */
    @Excel(name = "成员身份(成员/干部)")
    private String memberRole;

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setClubId(Long clubId) 
    {
        this.clubId = clubId;
    }

    public Long getClubId() 
    {
        return clubId;
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
    public void setJoinTime(Date joinTime) 
    {
        this.joinTime = joinTime;
    }

    public Date getJoinTime() 
    {
        return joinTime;
    }
    public void setMemberRole(String memberRole) 
    {
        this.memberRole = memberRole;
    }

    public String getMemberRole() 
    {
        return memberRole;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("memberId", getMemberId())
            .append("clubId", getClubId())
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("joinTime", getJoinTime())
            .append("memberRole", getMemberRole())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
