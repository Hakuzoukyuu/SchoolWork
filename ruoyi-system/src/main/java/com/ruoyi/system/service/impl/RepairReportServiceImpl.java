package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RepairReportMapper;
import com.ruoyi.system.domain.RepairReport;
import com.ruoyi.system.service.IRepairReportService;
import com.ruoyi.common.core.text.Convert;

/**
 * 维修报修Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class RepairReportServiceImpl implements IRepairReportService 
{
    @Autowired
    private RepairReportMapper repairReportMapper;

    /**
     * 查询维修报修
     * 
     * @param id 维修报修主键
     * @return 维修报修
     */
    @Override
    public RepairReport selectRepairReportById(Long id)
    {
        return repairReportMapper.selectRepairReportById(id);
    }

    /**
     * 查询维修报修列表
     * 
     * @param repairReport 维修报修
     * @return 维修报修
     */
    @Override
    public List<RepairReport> selectRepairReportList(RepairReport repairReport)
    {
        return repairReportMapper.selectRepairReportList(repairReport);
    }

    /**
     * 新增维修报修
     * 
     * @param repairReport 维修报修
     * @return 结果
     */
    @Override
    public int insertRepairReport(RepairReport repairReport)
    {
        repairReport.setCreateTime(DateUtils.getNowDate());
        return repairReportMapper.insertRepairReport(repairReport);
    }

    /**
     * 修改维修报修
     * 
     * @param repairReport 维修报修
     * @return 结果
     */
    @Override
    public int updateRepairReport(RepairReport repairReport)
    {
        repairReport.setUpdateTime(DateUtils.getNowDate());
        return repairReportMapper.updateRepairReport(repairReport);
    }

    /**
     * 批量删除维修报修
     * 
     * @param ids 需要删除的维修报修主键
     * @return 结果
     */
    @Override
    public int deleteRepairReportByIds(String ids)
    {
        return repairReportMapper.deleteRepairReportByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除维修报修信息
     * 
     * @param id 维修报修主键
     * @return 结果
     */
    @Override
    public int deleteRepairReportById(Long id)
    {
        return repairReportMapper.deleteRepairReportById(id);
    }
}
