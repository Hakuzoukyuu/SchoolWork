package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FinancialApproval;

/**
 * 财务审批Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface FinancialApprovalMapper 
{
    /**
     * 查询财务审批
     * 
     * @param financialId 财务审批主键
     * @return 财务审批
     */
    public FinancialApproval selectFinancialApprovalByFinancialId(Long financialId);

    /**
     * 查询财务审批列表
     * 
     * @param financialApproval 财务审批
     * @return 财务审批集合
     */
    public List<FinancialApproval> selectFinancialApprovalList(FinancialApproval financialApproval);

    /**
     * 新增财务审批
     * 
     * @param financialApproval 财务审批
     * @return 结果
     */
    public int insertFinancialApproval(FinancialApproval financialApproval);

    /**
     * 修改财务审批
     * 
     * @param financialApproval 财务审批
     * @return 结果
     */
    public int updateFinancialApproval(FinancialApproval financialApproval);

    /**
     * 删除财务审批
     * 
     * @param financialId 财务审批主键
     * @return 结果
     */
    public int deleteFinancialApprovalByFinancialId(Long financialId);

    /**
     * 批量删除财务审批
     * 
     * @param financialIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFinancialApprovalByFinancialIds(String[] financialIds);
}
