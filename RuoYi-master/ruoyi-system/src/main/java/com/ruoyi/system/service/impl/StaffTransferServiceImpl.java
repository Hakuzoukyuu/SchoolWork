package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StaffTransferMapper;
import com.ruoyi.system.domain.StaffTransfer;
import com.ruoyi.system.service.IStaffTransferService;
import com.ruoyi.common.core.text.Convert;

/**
 * 教职工调动管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class StaffTransferServiceImpl implements IStaffTransferService 
{
    @Autowired
    private StaffTransferMapper staffTransferMapper;

    /**
     * 查询教职工调动管理
     * 
     * @param transferId 教职工调动管理主键
     * @return 教职工调动管理
     */
    @Override
    public StaffTransfer selectStaffTransferByTransferId(Long transferId)
    {
        return staffTransferMapper.selectStaffTransferByTransferId(transferId);
    }

    /**
     * 查询教职工调动管理列表
     * 
     * @param staffTransfer 教职工调动管理
     * @return 教职工调动管理
     */
    @Override
    public List<StaffTransfer> selectStaffTransferList(StaffTransfer staffTransfer)
    {
        return staffTransferMapper.selectStaffTransferList(staffTransfer);
    }

    /**
     * 新增教职工调动管理
     * 
     * @param staffTransfer 教职工调动管理
     * @return 结果
     */
    @Override
    public int insertStaffTransfer(StaffTransfer staffTransfer)
    {
        return staffTransferMapper.insertStaffTransfer(staffTransfer);
    }

    /**
     * 修改教职工调动管理
     * 
     * @param staffTransfer 教职工调动管理
     * @return 结果
     */
    @Override
    public int updateStaffTransfer(StaffTransfer staffTransfer)
    {
        return staffTransferMapper.updateStaffTransfer(staffTransfer);
    }

    /**
     * 批量删除教职工调动管理
     * 
     * @param transferIds 需要删除的教职工调动管理主键
     * @return 结果
     */
    @Override
    public int deleteStaffTransferByTransferIds(String transferIds)
    {
        return staffTransferMapper.deleteStaffTransferByTransferIds(Convert.toStrArray(transferIds));
    }

    /**
     * 删除教职工调动管理信息
     * 
     * @param transferId 教职工调动管理主键
     * @return 结果
     */
    @Override
    public int deleteStaffTransferByTransferId(Long transferId)
    {
        return staffTransferMapper.deleteStaffTransferByTransferId(transferId);
    }
}
