package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.DormBed;
import com.ruoyi.system.mapper.DormDormitoryMapper;
import com.ruoyi.system.domain.DormDormitory;
import com.ruoyi.system.service.IDormDormitoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 宿舍信息主Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class DormDormitoryServiceImpl implements IDormDormitoryService 
{
    @Autowired
    private DormDormitoryMapper dormDormitoryMapper;

    /**
     * 查询宿舍信息主
     * 
     * @param dormId 宿舍信息主主键
     * @return 宿舍信息主
     */
    @Override
    public DormDormitory selectDormDormitoryByDormId(Long dormId)
    {
        return dormDormitoryMapper.selectDormDormitoryByDormId(dormId);
    }

    /**
     * 查询宿舍信息主列表
     * 
     * @param dormDormitory 宿舍信息主
     * @return 宿舍信息主
     */
    @Override
    public List<DormDormitory> selectDormDormitoryList(DormDormitory dormDormitory)
    {
        return dormDormitoryMapper.selectDormDormitoryList(dormDormitory);
    }

    /**
     * 新增宿舍信息主
     * 
     * @param dormDormitory 宿舍信息主
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDormDormitory(DormDormitory dormDormitory)
    {
        dormDormitory.setCreateTime(DateUtils.getNowDate());
        int rows = dormDormitoryMapper.insertDormDormitory(dormDormitory);
        insertDormBed(dormDormitory);
        return rows;
    }

    /**
     * 修改宿舍信息主
     * 
     * @param dormDormitory 宿舍信息主
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDormDormitory(DormDormitory dormDormitory)
    {
        dormDormitory.setUpdateTime(DateUtils.getNowDate());
        dormDormitoryMapper.deleteDormBedByDormId(dormDormitory.getDormId());
        insertDormBed(dormDormitory);
        return dormDormitoryMapper.updateDormDormitory(dormDormitory);
    }

    /**
     * 批量删除宿舍信息主
     * 
     * @param dormIds 需要删除的宿舍信息主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDormDormitoryByDormIds(String dormIds)
    {
        dormDormitoryMapper.deleteDormBedByDormIds(Convert.toStrArray(dormIds));
        return dormDormitoryMapper.deleteDormDormitoryByDormIds(Convert.toStrArray(dormIds));
    }

    /**
     * 删除宿舍信息主信息
     * 
     * @param dormId 宿舍信息主主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDormDormitoryByDormId(Long dormId)
    {
        dormDormitoryMapper.deleteDormBedByDormId(dormId);
        return dormDormitoryMapper.deleteDormDormitoryByDormId(dormId);
    }

    /**
     * 新增床位与学生入住子信息
     * 
     * @param dormDormitory 宿舍信息主对象
     */
    public void insertDormBed(DormDormitory dormDormitory)
    {
        List<DormBed> dormBedList = dormDormitory.getDormBedList();
        Long dormId = dormDormitory.getDormId();
        if (StringUtils.isNotNull(dormBedList))
        {
            List<DormBed> list = new ArrayList<DormBed>();
            for (DormBed dormBed : dormBedList)
            {
                dormBed.setDormId(dormId);
                list.add(dormBed);
            }
            if (list.size() > 0)
            {
                dormDormitoryMapper.batchDormBed(list);
            }
        }
    }
}
