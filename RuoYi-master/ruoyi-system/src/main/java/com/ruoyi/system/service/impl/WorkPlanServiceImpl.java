package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WorkPlanMapper;
import com.ruoyi.system.domain.WorkPlan;
import com.ruoyi.system.service.IWorkPlanService;
import com.ruoyi.common.core.text.Convert;

/**
 * 工作计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class WorkPlanServiceImpl implements IWorkPlanService 
{
    @Autowired
    private WorkPlanMapper workPlanMapper;

    /**
     * 查询工作计划
     * 
     * @param planId 工作计划主键
     * @return 工作计划
     */
    @Override
    public WorkPlan selectWorkPlanByPlanId(Long planId)
    {
        return workPlanMapper.selectWorkPlanByPlanId(planId);
    }

    /**
     * 查询工作计划列表
     * 
     * @param workPlan 工作计划
     * @return 工作计划
     */
    @Override
    public List<WorkPlan> selectWorkPlanList(WorkPlan workPlan)
    {
        return workPlanMapper.selectWorkPlanList(workPlan);
    }

    /**
     * 新增工作计划
     * 
     * @param workPlan 工作计划
     * @return 结果
     */
    @Override
    public int insertWorkPlan(WorkPlan workPlan)
    {
        workPlan.setCreateTime(DateUtils.getNowDate());
        return workPlanMapper.insertWorkPlan(workPlan);
    }

    /**
     * 修改工作计划
     * 
     * @param workPlan 工作计划
     * @return 结果
     */
    @Override
    public int updateWorkPlan(WorkPlan workPlan)
    {
        workPlan.setUpdateTime(DateUtils.getNowDate());
        return workPlanMapper.updateWorkPlan(workPlan);
    }

    /**
     * 批量删除工作计划
     * 
     * @param planIds 需要删除的工作计划主键
     * @return 结果
     */
    @Override
    public int deleteWorkPlanByPlanIds(String planIds)
    {
        return workPlanMapper.deleteWorkPlanByPlanIds(Convert.toStrArray(planIds));
    }

    /**
     * 删除工作计划信息
     * 
     * @param planId 工作计划主键
     * @return 结果
     */
    @Override
    public int deleteWorkPlanByPlanId(Long planId)
    {
        return workPlanMapper.deleteWorkPlanByPlanId(planId);
    }
}
