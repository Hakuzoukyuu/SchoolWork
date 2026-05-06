package com.ruoyi.system.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 食堂档口主对象 canteen_stall
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class CanteenStall extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 档口主键ID */
    private Long stallId;

    /** 档口编号 */
    @Excel(name = "档口编号")
    private String stallNo;

    /** 档口名称 */
    @Excel(name = "档口名称")
    private String stallName;

    /** 所属食堂 */
    @Excel(name = "所属食堂")
    private String canteenName;

    /** 档口负责人 */
    @Excel(name = "档口负责人")
    private String manager;

    /** 卫生检查结果：合格/不合格 */
    @Excel(name = "卫生检查结果：合格/不合格")
    private String hygieneStatus;

    /** 检查人 */
    @Excel(name = "检查人")
    private String checkPeople;

    /** 检查时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    /** 菜品台账子信息 */
    private List<CanteenDish> canteenDishList;

    public void setStallId(Long stallId) 
    {
        this.stallId = stallId;
    }

    public Long getStallId() 
    {
        return stallId;
    }

    public void setStallNo(String stallNo) 
    {
        this.stallNo = stallNo;
    }

    public String getStallNo() 
    {
        return stallNo;
    }

    public void setStallName(String stallName) 
    {
        this.stallName = stallName;
    }

    public String getStallName() 
    {
        return stallName;
    }

    public void setCanteenName(String canteenName) 
    {
        this.canteenName = canteenName;
    }

    public String getCanteenName() 
    {
        return canteenName;
    }

    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }

    public void setHygieneStatus(String hygieneStatus) 
    {
        this.hygieneStatus = hygieneStatus;
    }

    public String getHygieneStatus() 
    {
        return hygieneStatus;
    }

    public void setCheckPeople(String checkPeople) 
    {
        this.checkPeople = checkPeople;
    }

    public String getCheckPeople() 
    {
        return checkPeople;
    }

    public void setCheckTime(Date checkTime) 
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() 
    {
        return checkTime;
    }

    public List<CanteenDish> getCanteenDishList()
    {
        return canteenDishList;
    }

    public void setCanteenDishList(List<CanteenDish> canteenDishList)
    {
        this.canteenDishList = canteenDishList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stallId", getStallId())
            .append("stallNo", getStallNo())
            .append("stallName", getStallName())
            .append("canteenName", getCanteenName())
            .append("manager", getManager())
            .append("hygieneStatus", getHygieneStatus())
            .append("checkPeople", getCheckPeople())
            .append("checkTime", getCheckTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("canteenDishList", getCanteenDishList())
            .toString();
    }
}
