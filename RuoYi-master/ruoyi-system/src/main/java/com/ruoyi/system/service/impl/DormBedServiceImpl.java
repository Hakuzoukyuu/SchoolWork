package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DormBedMapper;
import com.ruoyi.system.domain.DormBed;
import com.ruoyi.system.service.IDormBedService;
import com.ruoyi.common.core.text.Convert;

/**
 * 床位与学生入住子Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class DormBedServiceImpl implements IDormBedService 
{
    @Autowired
    private DormBedMapper dormBedMapper;

    /**
     * 查询床位与学生入住子
     * 
     * @param bedId 床位与学生入住子主键
     * @return 床位与学生入住子
     */
    @Override
    public DormBed selectDormBedByBedId(Long bedId)
    {
        return dormBedMapper.selectDormBedByBedId(bedId);
    }

    /**
     * 查询床位与学生入住子列表
     * 
     * @param dormBed 床位与学生入住子
     * @return 床位与学生入住子
     */
    @Override
    public List<DormBed> selectDormBedList(DormBed dormBed)
    {
        return dormBedMapper.selectDormBedList(dormBed);
    }

    /**
     * 新增床位与学生入住子
     * 
     * @param dormBed 床位与学生入住子
     * @return 结果
     */
    @Override
    public int insertDormBed(DormBed dormBed)
    {
        dormBed.setCreateTime(DateUtils.getNowDate());
        return dormBedMapper.insertDormBed(dormBed);
    }

    /**
     * 修改床位与学生入住子
     * 
     * @param dormBed 床位与学生入住子
     * @return 结果
     */
    @Override
    public int updateDormBed(DormBed dormBed)
    {
        dormBed.setUpdateTime(DateUtils.getNowDate());
        return dormBedMapper.updateDormBed(dormBed);
    }

    /**
     * 批量删除床位与学生入住子
     * 
     * @param bedIds 需要删除的床位与学生入住子主键
     * @return 结果
     */
    @Override
    public int deleteDormBedByBedIds(String bedIds)
    {
        return dormBedMapper.deleteDormBedByBedIds(Convert.toStrArray(bedIds));
    }

    /**
     * 删除床位与学生入住子信息
     * 
     * @param bedId 床位与学生入住子主键
     * @return 结果
     */
    @Override
    public int deleteDormBedByBedId(Long bedId)
    {
        return dormBedMapper.deleteDormBedByBedId(bedId);
    }
}
