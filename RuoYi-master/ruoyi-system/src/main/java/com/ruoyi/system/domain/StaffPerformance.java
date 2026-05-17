package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 绩效考核管理对象 staff_performance
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class StaffPerformance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 绩效ID */
    private Long perfId;

    /** 教职工编号 */
    @Excel(name = "教职工编号")
    private String staffId;

    /** 考核类型：教学考核/行政考核 */
    @Excel(name = "考核类型：教学考核/行政考核")
    private String assessType;

    /** 考核学期/年度 */
    @Excel(name = "考核学期/年度")
    private String assessTerm;

    /** 综合评分 */
    @Excel(name = "综合评分")
    private Long scoreTotal;

    /** 考核结果：优秀/合格/不合格 */
    @Excel(name = "考核结果：优秀/合格/不合格")
    private String assessResult;

    /** 考核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "考核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date assessTime;

    public void setPerfId(Long perfId) 
    {
        this.perfId = perfId;
    }

    public Long getPerfId() 
    {
        return perfId;
    }

    public void setStaffId(String staffId) 
    {
        this.staffId = staffId;
    }

    public String getStaffId() 
    {
        return staffId;
    }

    public void setAssessType(String assessType) 
    {
        this.assessType = assessType;
    }

    public String getAssessType() 
    {
        return assessType;
    }

    public void setAssessTerm(String assessTerm) 
    {
        this.assessTerm = assessTerm;
    }

    public String getAssessTerm() 
    {
        return assessTerm;
    }

    public void setScoreTotal(Long scoreTotal) 
    {
        this.scoreTotal = scoreTotal;
    }

    public Long getScoreTotal() 
    {
        return scoreTotal;
    }

    public void setAssessResult(String assessResult) 
    {
        this.assessResult = assessResult;
    }

    public String getAssessResult() 
    {
        return assessResult;
    }

    public void setAssessTime(Date assessTime) 
    {
        this.assessTime = assessTime;
    }

    public Date getAssessTime() 
    {
        return assessTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("perfId", getPerfId())
            .append("staffId", getStaffId())
            .append("assessType", getAssessType())
            .append("assessTerm", getAssessTerm())
            .append("scoreTotal", getScoreTotal())
            .append("assessResult", getAssessResult())
            .append("assessTime", getAssessTime())
            .toString();
    }
}
