package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CanteenStall;
import com.ruoyi.system.domain.CanteenDish;

/**
 * 食堂档口主Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface CanteenStallMapper 
{
    /**
     * 查询食堂档口主
     * 
     * @param stallId 食堂档口主主键
     * @return 食堂档口主
     */
    public CanteenStall selectCanteenStallByStallId(Long stallId);

    /**
     * 查询食堂档口主列表
     * 
     * @param canteenStall 食堂档口主
     * @return 食堂档口主集合
     */
    public List<CanteenStall> selectCanteenStallList(CanteenStall canteenStall);

    /**
     * 新增食堂档口主
     * 
     * @param canteenStall 食堂档口主
     * @return 结果
     */
    public int insertCanteenStall(CanteenStall canteenStall);

    /**
     * 修改食堂档口主
     * 
     * @param canteenStall 食堂档口主
     * @return 结果
     */
    public int updateCanteenStall(CanteenStall canteenStall);

    /**
     * 删除食堂档口主
     * 
     * @param stallId 食堂档口主主键
     * @return 结果
     */
    public int deleteCanteenStallByStallId(Long stallId);

    /**
     * 批量删除食堂档口主
     * 
     * @param stallIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCanteenStallByStallIds(String[] stallIds);

    /**
     * 批量删除菜品台账子
     * 
     * @param stallIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCanteenDishByStallIds(String[] stallIds);
    
    /**
     * 批量新增菜品台账子
     * 
     * @param canteenDishList 菜品台账子列表
     * @return 结果
     */
    public int batchCanteenDish(List<CanteenDish> canteenDishList);
    

    /**
     * 通过食堂档口主主键删除菜品台账子信息
     * 
     * @param stallId 食堂档口主ID
     * @return 结果
     */
    public int deleteCanteenDishByStallId(Long stallId);
}
