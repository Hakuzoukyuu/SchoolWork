package com.ruoyi.Canteenmanagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Canteenmanagement.mapper.CanteenShopMapper;
import com.ruoyi.Canteenmanagement.domain.CanteenShop;
import com.ruoyi.Canteenmanagement.service.ICanteenShopService;
import com.ruoyi.common.core.text.Convert;

/**
 * 食堂店铺管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
@Service
public class CanteenShopServiceImpl implements ICanteenShopService 
{
    @Autowired
    private CanteenShopMapper canteenShopMapper;

    /**
     * 查询食堂店铺管理
     * 
     * @param shopId 食堂店铺管理主键
     * @return 食堂店铺管理
     */
    @Override
    public CanteenShop selectCanteenShopByShopId(Long shopId)
    {
        return canteenShopMapper.selectCanteenShopByShopId(shopId);
    }

    /**
     * 查询食堂店铺管理列表
     * 
     * @param canteenShop 食堂店铺管理
     * @return 食堂店铺管理
     */
    @Override
    public List<CanteenShop> selectCanteenShopList(CanteenShop canteenShop)
    {
        return canteenShopMapper.selectCanteenShopList(canteenShop);
    }

    /**
     * 新增食堂店铺管理
     * 
     * @param canteenShop 食堂店铺管理
     * @return 结果
     */
    @Override
    public int insertCanteenShop(CanteenShop canteenShop)
    {
        return canteenShopMapper.insertCanteenShop(canteenShop);
    }

    /**
     * 修改食堂店铺管理
     * 
     * @param canteenShop 食堂店铺管理
     * @return 结果
     */
    @Override
    public int updateCanteenShop(CanteenShop canteenShop)
    {
        return canteenShopMapper.updateCanteenShop(canteenShop);
    }

    /**
     * 批量删除食堂店铺管理
     * 
     * @param shopIds 需要删除的食堂店铺管理主键
     * @return 结果
     */
    @Override
    public int deleteCanteenShopByShopIds(String shopIds)
    {
        return canteenShopMapper.deleteCanteenShopByShopIds(Convert.toStrArray(shopIds));
    }

    /**
     * 删除食堂店铺管理信息
     * 
     * @param shopId 食堂店铺管理主键
     * @return 结果
     */
    @Override
    public int deleteCanteenShopByShopId(Long shopId)
    {
        return canteenShopMapper.deleteCanteenShopByShopId(shopId);
    }
}
