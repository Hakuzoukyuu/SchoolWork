package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资产管理对象 asset_management
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class AssetManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 资产类型：固定资产/耗材 */
    @Excel(name = "资产类型：固定资产/耗材")
    private String assetType;

    /** 资产名称 */
    @Excel(name = "资产名称")
    private String assetName;

    /** 资产规格 */
    @Excel(name = "资产规格")
    private String assetSpec;

    /** 资产数量 */
    @Excel(name = "资产数量")
    private Long assetNum;

    /** 领用部门 */
    @Excel(name = "领用部门")
    private String useDepartment;

    /** 领用人 */
    @Excel(name = "领用人")
    private String usePeople;

    /** 资产状态：正常/报废/领用中 */
    @Excel(name = "资产状态：正常/报废/领用中")
    private String assetStatus;

    /** 领用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "领用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiveTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setAssetType(String assetType) 
    {
        this.assetType = assetType;
    }

    public String getAssetType() 
    {
        return assetType;
    }

    public void setAssetName(String assetName) 
    {
        this.assetName = assetName;
    }

    public String getAssetName() 
    {
        return assetName;
    }

    public void setAssetSpec(String assetSpec) 
    {
        this.assetSpec = assetSpec;
    }

    public String getAssetSpec() 
    {
        return assetSpec;
    }

    public void setAssetNum(Long assetNum) 
    {
        this.assetNum = assetNum;
    }

    public Long getAssetNum() 
    {
        return assetNum;
    }

    public void setUseDepartment(String useDepartment) 
    {
        this.useDepartment = useDepartment;
    }

    public String getUseDepartment() 
    {
        return useDepartment;
    }

    public void setUsePeople(String usePeople) 
    {
        this.usePeople = usePeople;
    }

    public String getUsePeople() 
    {
        return usePeople;
    }

    public void setAssetStatus(String assetStatus) 
    {
        this.assetStatus = assetStatus;
    }

    public String getAssetStatus() 
    {
        return assetStatus;
    }

    public void setReceiveTime(Date receiveTime) 
    {
        this.receiveTime = receiveTime;
    }

    public Date getReceiveTime() 
    {
        return receiveTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assetType", getAssetType())
            .append("assetName", getAssetName())
            .append("assetSpec", getAssetSpec())
            .append("assetNum", getAssetNum())
            .append("useDepartment", getUseDepartment())
            .append("usePeople", getUsePeople())
            .append("assetStatus", getAssetStatus())
            .append("receiveTime", getReceiveTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
