package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StaffTransfer;

/**
 * 教职工调动管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IStaffTransferService 
{
    /**
     * 查询教职工调动管理
     * 
     * @param transferId 教职工调动管理主键
     * @return 教职工调动管理
     */
    public StaffTransfer selectStaffTransferByTransferId(Long transferId);

    /**
     * 查询教职工调动管理列表
     * 
     * @param staffTransfer 教职工调动管理
     * @return 教职工调动管理集合
     */
    public List<StaffTransfer> selectStaffTransferList(StaffTransfer staffTransfer);

    /**
     * 新增教职工调动管理
     * 
     * @param staffTransfer 教职工调动管理
     * @return 结果
     */
    public int insertStaffTransfer(StaffTransfer staffTransfer);

    /**
     * 修改教职工调动管理
     * 
     * @param staffTransfer 教职工调动管理
     * @return 结果
     */
    public int updateStaffTransfer(StaffTransfer staffTransfer);

    /**
     * 批量删除教职工调动管理
     * 
     * @param transferIds 需要删除的教职工调动管理主键集合
     * @return 结果
     */
    public int deleteStaffTransferByTransferIds(String transferIds);

    /**
     * 删除教职工调动管理信息
     * 
     * @param transferId 教职工调动管理主键
     * @return 结果
     */
    public int deleteStaffTransferByTransferId(Long transferId);
}
