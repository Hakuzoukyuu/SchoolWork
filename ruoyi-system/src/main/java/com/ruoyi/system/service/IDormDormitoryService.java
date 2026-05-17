package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.DormDormitory;

/**
 * 宿舍信息主Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IDormDormitoryService 
{
    /**
     * 查询宿舍信息主
     * 
     * @param dormId 宿舍信息主主键
     * @return 宿舍信息主
     */
    public DormDormitory selectDormDormitoryByDormId(Long dormId);

    /**
     * 查询宿舍信息主列表
     * 
     * @param dormDormitory 宿舍信息主
     * @return 宿舍信息主集合
     */
    public List<DormDormitory> selectDormDormitoryList(DormDormitory dormDormitory);

    /**
     * 新增宿舍信息主
     * 
     * @param dormDormitory 宿舍信息主
     * @return 结果
     */
    public int insertDormDormitory(DormDormitory dormDormitory);

    /**
     * 修改宿舍信息主
     * 
     * @param dormDormitory 宿舍信息主
     * @return 结果
     */
    public int updateDormDormitory(DormDormitory dormDormitory);

    /**
     * 批量删除宿舍信息主
     * 
     * @param dormIds 需要删除的宿舍信息主主键集合
     * @return 结果
     */
    public int deleteDormDormitoryByDormIds(String dormIds);

    /**
     * 删除宿舍信息主信息
     * 
     * @param dormId 宿舍信息主主键
     * @return 结果
     */
    public int deleteDormDormitoryByDormId(Long dormId);
}
