package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RepairReport;

/**
 * 维修报修Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface RepairReportMapper 
{
    /**
     * 查询维修报修
     * 
     * @param id 维修报修主键
     * @return 维修报修
     */
    public RepairReport selectRepairReportById(Long id);

    /**
     * 查询维修报修列表
     * 
     * @param repairReport 维修报修
     * @return 维修报修集合
     */
    public List<RepairReport> selectRepairReportList(RepairReport repairReport);

    /**
     * 新增维修报修
     * 
     * @param repairReport 维修报修
     * @return 结果
     */
    public int insertRepairReport(RepairReport repairReport);

    /**
     * 修改维修报修
     * 
     * @param repairReport 维修报修
     * @return 结果
     */
    public int updateRepairReport(RepairReport repairReport);

    /**
     * 删除维修报修
     * 
     * @param id 维修报修主键
     * @return 结果
     */
    public int deleteRepairReportById(Long id);

    /**
     * 批量删除维修报修
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRepairReportByIds(String[] ids);
}
