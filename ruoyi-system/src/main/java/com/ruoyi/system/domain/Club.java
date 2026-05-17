package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社团管理对象 club
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class Club extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 社团ID(主键) */
    private Long clubId;

    /** 社团名称 */
    @Excel(name = "社团名称")
    private String clubName;

    /** 社团类型 */
    @Excel(name = "社团类型")
    private String clubType;

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String leaderName;

    /** 负责人学号 */
    @Excel(name = "负责人学号")
    private String leaderId;

    /** 注册审批状态 */
    @Excel(name = "注册审批状态")
    private String approveStatus;

    /** 社团简介 */
    @Excel(name = "社团简介")
    private String clubDesc;

    /** 社团成员表信息 */
    private List<ClubMember> clubMemberList;

    public void setClubId(Long clubId) 
    {
        this.clubId = clubId;
    }

    public Long getClubId() 
    {
        return clubId;
    }

    public void setClubName(String clubName) 
    {
        this.clubName = clubName;
    }

    public String getClubName() 
    {
        return clubName;
    }

    public void setClubType(String clubType) 
    {
        this.clubType = clubType;
    }

    public String getClubType() 
    {
        return clubType;
    }

    public void setLeaderName(String leaderName) 
    {
        this.leaderName = leaderName;
    }

    public String getLeaderName() 
    {
        return leaderName;
    }

    public void setLeaderId(String leaderId) 
    {
        this.leaderId = leaderId;
    }

    public String getLeaderId() 
    {
        return leaderId;
    }

    public void setApproveStatus(String approveStatus) 
    {
        this.approveStatus = approveStatus;
    }

    public String getApproveStatus() 
    {
        return approveStatus;
    }

    public void setClubDesc(String clubDesc) 
    {
        this.clubDesc = clubDesc;
    }

    public String getClubDesc() 
    {
        return clubDesc;
    }

    public List<ClubMember> getClubMemberList()
    {
        return clubMemberList;
    }

    public void setClubMemberList(List<ClubMember> clubMemberList)
    {
        this.clubMemberList = clubMemberList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("clubId", getClubId())
            .append("clubName", getClubName())
            .append("clubType", getClubType())
            .append("leaderName", getLeaderName())
            .append("leaderId", getLeaderId())
            .append("approveStatus", getApproveStatus())
            .append("clubDesc", getClubDesc())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("clubMemberList", getClubMemberList())
            .toString();
    }
}
