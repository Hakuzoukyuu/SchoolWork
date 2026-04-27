package com.ruoyi.Canteenmanagement.service;

import java.util.List;
import com.ruoyi.Canteenmanagement.domain.CanteenShop;

/**
 * 食堂店铺管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
public interface ICanteenShopService 
{
    /**
     * 查询食堂店铺管理
     * 
     * @param shopId 食堂店铺管理主键
     * @return 食堂店铺管理
     */
    public CanteenShop selectCanteenShopByShopId(Long shopId);

    /**
     * 查询食堂店铺管理列表
     * 
     * @param canteenShop 食堂店铺管理
     * @return 食堂店铺管理集合
     */
    public List<CanteenShop> selectCanteenShopList(CanteenShop canteenShop);

    /**
     * 新增食堂店铺管理
     * 
     * @param canteenShop 食堂店铺管理
     * @return 结果
     */
    public int insertCanteenShop(CanteenShop canteenShop);

    /**
     * 修改食堂店铺管理
     * 
     * @param canteenShop 食堂店铺管理
     * @return 结果
     */
    public int updateCanteenShop(CanteenShop canteenShop);

    /**
     * 批量删除食堂店铺管理
     * 
     * @param shopIds 需要删除的食堂店铺管理主键集合
     * @return 结果
     */
    public int deleteCanteenShopByShopIds(String shopIds);

    /**
     * 删除食堂店铺管理信息
     * 
     * @param shopId 食堂店铺管理主键
     * @return 结果
     */
    public int deleteCanteenShopByShopId(Long shopId);
}
