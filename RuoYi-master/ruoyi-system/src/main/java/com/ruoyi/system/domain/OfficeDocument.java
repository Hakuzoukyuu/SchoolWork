package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公文流转对象 office_document
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class OfficeDocument extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公文ID */
    private Long docId;

    /** 公文标题 */
    @Excel(name = "公文标题")
    private String docTitle;

    /** 公文文号 */
    @Excel(name = "公文文号")
    private String docNo;

    /** 公文类型：发文/收文 */
    @Excel(name = "公文类型：发文/收文")
    private String docType;

    /** 公文内容 */
    @Excel(name = "公文内容")
    private String docContent;

    /** 公文附件 */
    @Excel(name = "公文附件")
    private String fileUrl;

    /** 发文单位/人 */
    @Excel(name = "发文单位/人")
    private String sender;

    /** 收文单位/人 */
    @Excel(name = "收文单位/人")
    private String receiver;

    /** 流程状态：拟稿/审批中/已签发/已归档 */
    @Excel(name = "流程状态：拟稿/审批中/已签发/已归档")
    private String flowStatus;

    /** 当前审批人 */
    @Excel(name = "当前审批人")
    private String currentApprover;

    /** 审批历史记录 */
    @Excel(name = "审批历史记录")
    private String approveHistory;

    /** 归档时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "归档时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date archiveTime;

    public void setDocId(Long docId) 
    {
        this.docId = docId;
    }

    public Long getDocId() 
    {
        return docId;
    }

    public void setDocTitle(String docTitle) 
    {
        this.docTitle = docTitle;
    }

    public String getDocTitle() 
    {
        return docTitle;
    }

    public void setDocNo(String docNo) 
    {
        this.docNo = docNo;
    }

    public String getDocNo() 
    {
        return docNo;
    }

    public void setDocType(String docType) 
    {
        this.docType = docType;
    }

    public String getDocType() 
    {
        return docType;
    }

    public void setDocContent(String docContent) 
    {
        this.docContent = docContent;
    }

    public String getDocContent() 
    {
        return docContent;
    }

    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }

    public void setSender(String sender) 
    {
        this.sender = sender;
    }

    public String getSender() 
    {
        return sender;
    }

    public void setReceiver(String receiver) 
    {
        this.receiver = receiver;
    }

    public String getReceiver() 
    {
        return receiver;
    }

    public void setFlowStatus(String flowStatus) 
    {
        this.flowStatus = flowStatus;
    }

    public String getFlowStatus() 
    {
        return flowStatus;
    }

    public void setCurrentApprover(String currentApprover) 
    {
        this.currentApprover = currentApprover;
    }

    public String getCurrentApprover() 
    {
        return currentApprover;
    }

    public void setApproveHistory(String approveHistory) 
    {
        this.approveHistory = approveHistory;
    }

    public String getApproveHistory() 
    {
        return approveHistory;
    }

    public void setArchiveTime(Date archiveTime) 
    {
        this.archiveTime = archiveTime;
    }

    public Date getArchiveTime() 
    {
        return archiveTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("docId", getDocId())
            .append("docTitle", getDocTitle())
            .append("docNo", getDocNo())
            .append("docType", getDocType())
            .append("docContent", getDocContent())
            .append("fileUrl", getFileUrl())
            .append("sender", getSender())
            .append("receiver", getReceiver())
            .append("flowStatus", getFlowStatus())
            .append("currentApprover", getCurrentApprover())
            .append("approveHistory", getApproveHistory())
            .append("archiveTime", getArchiveTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
