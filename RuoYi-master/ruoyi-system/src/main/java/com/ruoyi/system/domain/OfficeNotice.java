package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 行政办公通知对象 office_notice
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class OfficeNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告ID */
    private Long noticeId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String noticeTitle;

    /** 公告类型：全校公告/部门通知/定向消息 */
    @Excel(name = "公告类型：全校公告/部门通知/定向消息")
    private String noticeType;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String noticeContent;

    /** 接收部门 */
    @Excel(name = "接收部门")
    private String receiverDept;

    /** 接收人ID列表 */
    @Excel(name = "接收人ID列表")
    private String receiverUser;

    /** 附件地址 */
    @Excel(name = "附件地址")
    private String fileUrl;

    /** 发布人 */
    @Excel(name = "发布人")
    private String publisher;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 状态：草稿/已发布/已撤回 */
    @Excel(name = "状态：草稿/已发布/已撤回")
    private String status;

    public void setNoticeId(Long noticeId) 
    {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() 
    {
        return noticeId;
    }

    public void setNoticeTitle(String noticeTitle) 
    {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeTitle() 
    {
        return noticeTitle;
    }

    public void setNoticeType(String noticeType) 
    {
        this.noticeType = noticeType;
    }

    public String getNoticeType() 
    {
        return noticeType;
    }

    public void setNoticeContent(String noticeContent) 
    {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent() 
    {
        return noticeContent;
    }

    public void setReceiverDept(String receiverDept) 
    {
        this.receiverDept = receiverDept;
    }

    public String getReceiverDept() 
    {
        return receiverDept;
    }

    public void setReceiverUser(String receiverUser) 
    {
        this.receiverUser = receiverUser;
    }

    public String getReceiverUser() 
    {
        return receiverUser;
    }

    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }

    public void setPublisher(String publisher) 
    {
        this.publisher = publisher;
    }

    public String getPublisher() 
    {
        return publisher;
    }

    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
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
            .append("noticeId", getNoticeId())
            .append("noticeTitle", getNoticeTitle())
            .append("noticeType", getNoticeType())
            .append("noticeContent", getNoticeContent())
            .append("receiverDept", getReceiverDept())
            .append("receiverUser", getReceiverUser())
            .append("fileUrl", getFileUrl())
            .append("publisher", getPublisher())
            .append("publishTime", getPublishTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
