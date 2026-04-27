package com.ruoyi.Canteenmanagement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 食堂店铺管理对象 canteen_shop
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
public class CanteenShop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 店铺编号 */
    private Long shopId;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String shopName;

    /** 店铺所属位置 */
    @Excel(name = "店铺所属位置")
    private String location;

    /** 店铺类型 */
    @Excel(name = "店铺类型")
    private String shopType;

    /** 营业状态 */
    @Excel(name = "营业状态")
    private String status;

    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }

    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }

    public void setShopType(String shopType) 
    {
        this.shopType = shopType;
    }

    public String getShopType() 
    {
        return shopType;
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
            .append("shopId", getShopId())
            .append("shopName", getShopName())
            .append("location", getLocation())
            .append("shopType", getShopType())
            .append("status", getStatus())
            .toString();
    }
}
