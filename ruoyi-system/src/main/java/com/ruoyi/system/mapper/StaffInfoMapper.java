package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StaffInfo;

/**
 * 教职工基础档案主Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface StaffInfoMapper 
{
    /**
     * 查询教职工基础档案主
     * 
     * @param staffId 教职工基础档案主主键
     * @return 教职工基础档案主
     */
    public StaffInfo selectStaffInfoByStaffId(String staffId);

    /**
     * 查询教职工基础档案主列表
     * 
     * @param staffInfo 教职工基础档案主
     * @return 教职工基础档案主集合
     */
    public List<StaffInfo> selectStaffInfoList(StaffInfo staffInfo);

    /**
     * 新增教职工基础档案主
     * 
     * @param staffInfo 教职工基础档案主
     * @return 结果
     */
    public int insertStaffInfo(StaffInfo staffInfo);

    /**
     * 修改教职工基础档案主
     * 
     * @param staffInfo 教职工基础档案主
     * @return 结果
     */
    public int updateStaffInfo(StaffInfo staffInfo);

    /**
     * 删除教职工基础档案主
     * 
     * @param staffId 教职工基础档案主主键
     * @return 结果
     */
    public int deleteStaffInfoByStaffId(String staffId);

    /**
     * 批量删除教职工基础档案主
     * 
     * @param staffIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStaffInfoByStaffIds(String[] staffIds);
}
