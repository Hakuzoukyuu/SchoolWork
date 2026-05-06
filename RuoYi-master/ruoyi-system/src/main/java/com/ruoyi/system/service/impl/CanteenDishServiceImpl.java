package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CanteenDishMapper;
import com.ruoyi.system.domain.CanteenDish;
import com.ruoyi.system.service.ICanteenDishService;
import com.ruoyi.common.core.text.Convert;

/**
 * 菜品台账子Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class CanteenDishServiceImpl implements ICanteenDishService 
{
    @Autowired
    private CanteenDishMapper canteenDishMapper;

    /**
     * 查询菜品台账子
     * 
     * @param dishId 菜品台账子主键
     * @return 菜品台账子
     */
    @Override
    public CanteenDish selectCanteenDishByDishId(Long dishId)
    {
        return canteenDishMapper.selectCanteenDishByDishId(dishId);
    }

    /**
     * 查询菜品台账子列表
     * 
     * @param canteenDish 菜品台账子
     * @return 菜品台账子
     */
    @Override
    public List<CanteenDish> selectCanteenDishList(CanteenDish canteenDish)
    {
        return canteenDishMapper.selectCanteenDishList(canteenDish);
    }

    /**
     * 新增菜品台账子
     * 
     * @param canteenDish 菜品台账子
     * @return 结果
     */
    @Override
    public int insertCanteenDish(CanteenDish canteenDish)
    {
        canteenDish.setCreateTime(DateUtils.getNowDate());
        return canteenDishMapper.insertCanteenDish(canteenDish);
    }

    /**
     * 修改菜品台账子
     * 
     * @param canteenDish 菜品台账子
     * @return 结果
     */
    @Override
    public int updateCanteenDish(CanteenDish canteenDish)
    {
        canteenDish.setUpdateTime(DateUtils.getNowDate());
        return canteenDishMapper.updateCanteenDish(canteenDish);
    }

    /**
     * 批量删除菜品台账子
     * 
     * @param dishIds 需要删除的菜品台账子主键
     * @return 结果
     */
    @Override
    public int deleteCanteenDishByDishIds(String dishIds)
    {
        return canteenDishMapper.deleteCanteenDishByDishIds(Convert.toStrArray(dishIds));
    }

    /**
     * 删除菜品台账子信息
     * 
     * @param dishId 菜品台账子主键
     * @return 结果
     */
    @Override
    public int deleteCanteenDishByDishId(Long dishId)
    {
        return canteenDishMapper.deleteCanteenDishByDishId(dishId);
    }
}
