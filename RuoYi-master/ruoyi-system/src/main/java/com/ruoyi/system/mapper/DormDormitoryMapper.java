package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DormDormitory;
import com.ruoyi.system.domain.DormBed;

/**
 * 宿舍信息主Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface DormDormitoryMapper 
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
     * 删除宿舍信息主
     * 
     * @param dormId 宿舍信息主主键
     * @return 结果
     */
    public int deleteDormDormitoryByDormId(Long dormId);

    /**
     * 批量删除宿舍信息主
     * 
     * @param dormIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormDormitoryByDormIds(String[] dormIds);

    /**
     * 批量删除床位与学生入住子
     * 
     * @param dormIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormBedByDormIds(String[] dormIds);
    
    /**
     * 批量新增床位与学生入住子
     * 
     * @param dormBedList 床位与学生入住子列表
     * @return 结果
     */
    public int batchDormBed(List<DormBed> dormBedList);
    

    /**
     * 通过宿舍信息主主键删除床位与学生入住子信息
     * 
     * @param dormId 宿舍信息主ID
     * @return 结果
     */
    public int deleteDormBedByDormId(Long dormId);
}
