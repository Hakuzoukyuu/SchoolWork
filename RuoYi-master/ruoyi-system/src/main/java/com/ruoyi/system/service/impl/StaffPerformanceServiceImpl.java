package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StaffPerformanceMapper;
import com.ruoyi.system.domain.StaffPerformance;
import com.ruoyi.system.service.IStaffPerformanceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 绩效考核管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class StaffPerformanceServiceImpl implements IStaffPerformanceService 
{
    @Autowired
    private StaffPerformanceMapper staffPerformanceMapper;

    /**
     * 查询绩效考核管理
     * 
     * @param perfId 绩效考核管理主键
     * @return 绩效考核管理
     */
    @Override
    public StaffPerformance selectStaffPerformanceByPerfId(Long perfId)
    {
        return staffPerformanceMapper.selectStaffPerformanceByPerfId(perfId);
    }

    /**
     * 查询绩效考核管理列表
     * 
     * @param staffPerformance 绩效考核管理
     * @return 绩效考核管理
     */
    @Override
    public List<StaffPerformance> selectStaffPerformanceList(StaffPerformance staffPerformance)
    {
        return staffPerformanceMapper.selectStaffPerformanceList(staffPerformance);
    }

    /**
     * 新增绩效考核管理
     * 
     * @param staffPerformance 绩效考核管理
     * @return 结果
     */
    @Override
    public int insertStaffPerformance(StaffPerformance staffPerformance)
    {
        return staffPerformanceMapper.insertStaffPerformance(staffPerformance);
    }

    /**
     * 修改绩效考核管理
     * 
     * @param staffPerformance 绩效考核管理
     * @return 结果
     */
    @Override
    public int updateStaffPerformance(StaffPerformance staffPerformance)
    {
        return staffPerformanceMapper.updateStaffPerformance(staffPerformance);
    }

    /**
     * 批量删除绩效考核管理
     * 
     * @param perfIds 需要删除的绩效考核管理主键
     * @return 结果
     */
    @Override
    public int deleteStaffPerformanceByPerfIds(String perfIds)
    {
        return staffPerformanceMapper.deleteStaffPerformanceByPerfIds(Convert.toStrArray(perfIds));
    }

    /**
     * 删除绩效考核管理信息
     * 
     * @param perfId 绩效考核管理主键
     * @return 结果
     */
    @Override
    public int deleteStaffPerformanceByPerfId(Long perfId)
    {
        return staffPerformanceMapper.deleteStaffPerformanceByPerfId(perfId);
    }
}
