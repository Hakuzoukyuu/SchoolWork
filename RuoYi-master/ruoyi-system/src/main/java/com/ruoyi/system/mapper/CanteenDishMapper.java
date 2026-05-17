package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CanteenDish;

/**
 * 菜品台账子Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface CanteenDishMapper 
{
    /**
     * 查询菜品台账子
     * 
     * @param dishId 菜品台账子主键
     * @return 菜品台账子
     */
    public CanteenDish selectCanteenDishByDishId(Long dishId);

    /**
     * 查询菜品台账子列表
     * 
     * @param canteenDish 菜品台账子
     * @return 菜品台账子集合
     */
    public List<CanteenDish> selectCanteenDishList(CanteenDish canteenDish);

    /**
     * 新增菜品台账子
     * 
     * @param canteenDish 菜品台账子
     * @return 结果
     */
    public int insertCanteenDish(CanteenDish canteenDish);

    /**
     * 修改菜品台账子
     * 
     * @param canteenDish 菜品台账子
     * @return 结果
     */
    public int updateCanteenDish(CanteenDish canteenDish);

    /**
     * 删除菜品台账子
     * 
     * @param dishId 菜品台账子主键
     * @return 结果
     */
    public int deleteCanteenDishByDishId(Long dishId);

    /**
     * 批量删除菜品台账子
     * 
     * @param dishIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCanteenDishByDishIds(String[] dishIds);
}
