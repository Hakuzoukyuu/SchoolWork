package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CanteenStall;

/**
 * 食堂档口主Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface ICanteenStallService 
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
     * 批量删除食堂档口主
     * 
     * @param stallIds 需要删除的食堂档口主主键集合
     * @return 结果
     */
    public int deleteCanteenStallByStallIds(String stallIds);

    /**
     * 删除食堂档口主信息
     * 
     * @param stallId 食堂档口主主键
     * @return 结果
     */
    public int deleteCanteenStallByStallId(Long stallId);
}
