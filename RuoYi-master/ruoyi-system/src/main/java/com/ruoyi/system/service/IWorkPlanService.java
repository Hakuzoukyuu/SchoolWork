package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.WorkPlan;

/**
 * 工作计划Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IWorkPlanService 
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
     * 批量删除工作计划
     * 
     * @param planIds 需要删除的工作计划主键集合
     * @return 结果
     */
    public int deleteWorkPlanByPlanIds(String planIds);

    /**
     * 删除工作计划信息
     * 
     * @param planId 工作计划主键
     * @return 结果
     */
    public int deleteWorkPlanByPlanId(Long planId);
}
