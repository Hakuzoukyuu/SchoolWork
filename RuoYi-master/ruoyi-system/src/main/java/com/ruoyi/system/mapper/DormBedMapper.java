package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.DormBed;

/**
 * 床位与学生入住子Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface DormBedMapper 
{
    /**
     * 查询床位与学生入住子
     * 
     * @param bedId 床位与学生入住子主键
     * @return 床位与学生入住子
     */
    public DormBed selectDormBedByBedId(Long bedId);

    /**
     * 查询床位与学生入住子列表
     * 
     * @param dormBed 床位与学生入住子
     * @return 床位与学生入住子集合
     */
    public List<DormBed> selectDormBedList(DormBed dormBed);

    /**
     * 新增床位与学生入住子
     * 
     * @param dormBed 床位与学生入住子
     * @return 结果
     */
    public int insertDormBed(DormBed dormBed);

    /**
     * 修改床位与学生入住子
     * 
     * @param dormBed 床位与学生入住子
     * @return 结果
     */
    public int updateDormBed(DormBed dormBed);

    /**
     * 删除床位与学生入住子
     * 
     * @param bedId 床位与学生入住子主键
     * @return 结果
     */
    public int deleteDormBedByBedId(Long bedId);

    /**
     * 批量删除床位与学生入住子
     * 
     * @param bedIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormBedByBedIds(String[] bedIds);
}
