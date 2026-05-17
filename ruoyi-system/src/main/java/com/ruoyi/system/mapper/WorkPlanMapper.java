package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WorkPlan;

/**
 * 工作计划Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface WorkPlanMapper 
{
    /**
     * 查询工作计划
     * 
     * @param planId 工作计划主键
     * @return 工作计划
     */
    public WorkPlan selectWorkPlanByPlanId(Long planId);

    /**
     * 查询工作计划列表
     * 
     * @param workPlan 工作计划
     * @return 工作计划集合
     */
    public List<WorkPlan> selectWorkPlanList(WorkPlan workPlan);

    /**
     * 新增工作计划
     * 
     * @param workPlan 工作计划
     * @return 结果
     */
    public int insertWorkPlan(WorkPlan workPlan);

    /**
     * 修改工作计划
     * 
     * @param workPlan 工作计划
     * @return 结果
     */
    public int updateWorkPlan(WorkPlan workPlan);

    /**
     * 删除工作计划
     * 
     * @param planId 工作计划主键
     * @return 结果
     */
    public int deleteWorkPlanByPlanId(Long planId);

    /**
     * 批量删除工作计划
     * 
     * @param planIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWorkPlanByPlanIds(String[] planIds);
}
