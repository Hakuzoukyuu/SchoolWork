package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 菜品台账子对象 canteen_dish
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class CanteenDish extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 菜品主键ID */
    private Long dishId;

    /** 关联档口ID（业务关联） */
    @Excel(name = "关联档口ID", readConverterExp = "业=务关联")
    private Long stallId;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private String dishName;

    /** 菜品单价 */
    @Excel(name = "菜品单价")
    private BigDecimal dishPrice;

    /** 菜品分类：素菜/荤菜/汤品 */
    @Excel(name = "菜品分类：素菜/荤菜/汤品")
    private String dishCategory;

    /** 销售状态：在售/售罄 */
    @Excel(name = "销售状态：在售/售罄")
    private String saleStatus;

    /** 当日销量 */
    @Excel(name = "当日销量")
    private Long consumeCount;

    /** 菜品消费总额 */
    @Excel(name = "菜品消费总额")
    private BigDecimal consumeTotal;

    public void setDishId(Long dishId) 
    {
        this.dishId = dishId;
    }

    public Long getDishId() 
    {
        return dishId;
    }

    public void setStallId(Long stallId) 
    {
        this.stallId = stallId;
    }

    public Long getStallId() 
    {
        return stallId;
    }

    public void setDishName(String dishName) 
    {
        this.dishName = dishName;
    }

    public String getDishName() 
    {
        return dishName;
    }

    public void setDishPrice(BigDecimal dishPrice) 
    {
        this.dishPrice = dishPrice;
    }

    public BigDecimal getDishPrice() 
    {
        return dishPrice;
    }

    public void setDishCategory(String dishCategory) 
    {
        this.dishCategory = dishCategory;
    }

    public String getDishCategory() 
    {
        return dishCategory;
    }

    public void setSaleStatus(String saleStatus) 
    {
        this.saleStatus = saleStatus;
    }

    public String getSaleStatus() 
    {
        return saleStatus;
    }

    public void setConsumeCount(Long consumeCount) 
    {
        this.consumeCount = consumeCount;
    }

    public Long getConsumeCount() 
    {
        return consumeCount;
    }

    public void setConsumeTotal(BigDecimal consumeTotal) 
    {
        this.consumeTotal = consumeTotal;
    }

    public BigDecimal getConsumeTotal() 
    {
        return consumeTotal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dishId", getDishId())
            .append("stallId", getStallId())
            .append("dishName", getDishName())
            .append("dishPrice", getDishPrice())
            .append("dishCategory", getDishCategory())
            .append("saleStatus", getSaleStatus())
            .append("consumeCount", getConsumeCount())
            .append("consumeTotal", getConsumeTotal())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
