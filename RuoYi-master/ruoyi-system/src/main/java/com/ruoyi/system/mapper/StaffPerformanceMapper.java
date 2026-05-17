package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StaffPerformance;

/**
 * 绩效考核管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface StaffPerformanceMapper 
{
    /**
     * 查询绩效考核管理
     * 
     * @param perfId 绩效考核管理主键
     * @return 绩效考核管理
     */
    public StaffPerformance selectStaffPerformanceByPerfId(Long perfId);

    /**
     * 查询绩效考核管理列表
     * 
     * @param staffPerformance 绩效考核管理
     * @return 绩效考核管理集合
     */
    public List<StaffPerformance> selectStaffPerformanceList(StaffPerformance staffPerformance);

    /**
     * 新增绩效考核管理
     * 
     * @param staffPerformance 绩效考核管理
     * @return 结果
     */
    public int insertStaffPerformance(StaffPerformance staffPerformance);

    /**
     * 修改绩效考核管理
     * 
     * @param staffPerformance 绩效考核管理
     * @return 结果
     */
    public int updateStaffPerformance(StaffPerformance staffPerformance);

    /**
     * 删除绩效考核管理
     * 
     * @param perfId 绩效考核管理主键
     * @return 结果
     */
    public int deleteStaffPerformanceByPerfId(Long perfId);

    /**
     * 批量删除绩效考核管理
     * 
     * @param perfIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStaffPerformanceByPerfIds(String[] perfIds);
}
