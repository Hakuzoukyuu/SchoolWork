package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学院信息对象 college_info
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
public class CollegeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学院编号 */
    private Long collegeId;

    /** 学院名称 */
    @Excel(name = "学院名称")
    private String collegeName;

    /** 学院位置 */
    @Excel(name = "学院位置")
    private String location;

    /** 学院官网URL */
    @Excel(name = "学院官网URL")
    private String officialUrl;

    public void setCollegeId(Long collegeId) 
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId() 
    {
        return collegeId;
    }

    public void setCollegeName(String collegeName) 
    {
        this.collegeName = collegeName;
    }

    public String getCollegeName() 
    {
        return collegeName;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setOfficialUrl(String officialUrl) 
    {
        this.officialUrl = officialUrl;
    }

    public String getOfficialUrl() 
    {
        return officialUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collegeId", getCollegeId())
            .append("collegeName", getCollegeName())
            .append("location", getLocation())
            .append("officialUrl", getOfficialUrl())
            .toString();
    }
}
