package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会议管理对象 meeting_management
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class MeetingManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会议ID */
    private Long meetingId;

    /** 会议名称 */
    @Excel(name = "会议名称")
    private String meetingTitle;

    /** 会议室 */
    @Excel(name = "会议室")
    private String meetingRoom;

    /** 会议日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "会议日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date meetingDate;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 组织者 */
    @Excel(name = "组织者")
    private String organizer;

    /** 参会人员列表 */
    @Excel(name = "参会人员列表")
    private String attendees;

    /** 会议内容 */
    @Excel(name = "会议内容")
    private String meetingContent;

    /** 会议纪要 */
    @Excel(name = "会议纪要")
    private String meetingMinutes;

    /** 会议附件 */
    @Excel(name = "会议附件")
    private String fileUrl;

    /** 状态：已预约/进行中/已结束 */
    @Excel(name = "状态：已预约/进行中/已结束")
    private String status;

    public void setMeetingId(Long meetingId) 
    {
        this.meetingId = meetingId;
    }

    public Long getMeetingId() 
    {
        return meetingId;
    }

    public void setMeetingTitle(String meetingTitle) 
    {
        this.meetingTitle = meetingTitle;
    }

    public String getMeetingTitle() 
    {
        return meetingTitle;
    }

    public void setMeetingRoom(String meetingRoom) 
    {
        this.meetingRoom = meetingRoom;
    }

    public String getMeetingRoom() 
    {
        return meetingRoom;
    }

    public void setMeetingDate(Date meetingDate) 
    {
        this.meetingDate = meetingDate;
    }

    public Date getMeetingDate() 
    {
        return meetingDate;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setOrganizer(String organizer) 
    {
        this.organizer = organizer;
    }

    public String getOrganizer() 
    {
        return organizer;
    }

    public void setAttendees(String attendees) 
    {
        this.attendees = attendees;
    }

    public String getAttendees() 
    {
        return attendees;
    }

    public void setMeetingContent(String meetingContent) 
    {
        this.meetingContent = meetingContent;
    }

    public String getMeetingContent() 
    {
        return meetingContent;
    }

    public void setMeetingMinutes(String meetingMinutes) 
    {
        this.meetingMinutes = meetingMinutes;
    }

    public String getMeetingMinutes() 
    {
        return meetingMinutes;
    }

    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("meetingId", getMeetingId())
            .append("meetingTitle", getMeetingTitle())
            .append("meetingRoom", getMeetingRoom())
            .append("meetingDate", getMeetingDate())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("organizer", getOrganizer())
            .append("attendees", getAttendees())
            .append("meetingContent", getMeetingContent())
            .append("meetingMinutes", getMeetingMinutes())
            .append("fileUrl", getFileUrl())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
