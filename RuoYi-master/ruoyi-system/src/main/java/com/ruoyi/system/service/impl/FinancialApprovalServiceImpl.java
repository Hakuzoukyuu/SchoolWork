package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FinancialApprovalMapper;
import com.ruoyi.system.domain.FinancialApproval;
import com.ruoyi.system.service.IFinancialApprovalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 财务审批Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class FinancialApprovalServiceImpl implements IFinancialApprovalService 
{
    @Autowired
    private FinancialApprovalMapper financialApprovalMapper;

    /**
     * 查询财务审批
     * 
     * @param financialId 财务审批主键
     * @return 财务审批
     */
    @Override
    public FinancialApproval selectFinancialApprovalByFinancialId(Long financialId)
    {
        return financialApprovalMapper.selectFinancialApprovalByFinancialId(financialId);
    }

    /**
     * 查询财务审批列表
     * 
     * @param financialApproval 财务审批
     * @return 财务审批
     */
    @Override
    public List<FinancialApproval> selectFinancialApprovalList(FinancialApproval financialApproval)
    {
        return financialApprovalMapper.selectFinancialApprovalList(financialApproval);
    }

    /**
     * 新增财务审批
     * 
     * @param financialApproval 财务审批
     * @return 结果
     */
    @Override
    public int insertFinancialApproval(FinancialApproval financialApproval)
    {
        financialApproval.setCreateTime(DateUtils.getNowDate());
        return financialApprovalMapper.insertFinancialApproval(financialApproval);
    }

    /**
     * 修改财务审批
     * 
     * @param financialApproval 财务审批
     * @return 结果
     */
    @Override
    public int updateFinancialApproval(FinancialApproval financialApproval)
    {
        financialApproval.setUpdateTime(DateUtils.getNowDate());
        return financialApprovalMapper.updateFinancialApproval(financialApproval);
    }

    /**
     * 批量删除财务审批
     * 
     * @param financialIds 需要删除的财务审批主键
     * @return 结果
     */
    @Override
    public int deleteFinancialApprovalByFinancialIds(String financialIds)
    {
        return financialApprovalMapper.deleteFinancialApprovalByFinancialIds(Convert.toStrArray(financialIds));
    }

    /**
     * 删除财务审批信息
     * 
     * @param financialId 财务审批主键
     * @return 结果
     */
    @Override
    public int deleteFinancialApprovalByFinancialId(Long financialId)
    {
        return financialApprovalMapper.deleteFinancialApprovalByFinancialId(financialId);
    }
}
