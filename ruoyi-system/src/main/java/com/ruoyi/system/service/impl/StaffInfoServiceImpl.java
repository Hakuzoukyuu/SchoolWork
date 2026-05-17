package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StaffInfoMapper;
import com.ruoyi.system.domain.StaffInfo;
import com.ruoyi.system.service.IStaffInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 教职工基础档案主Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class StaffInfoServiceImpl implements IStaffInfoService 
{
    @Autowired
    private StaffInfoMapper staffInfoMapper;

    /**
     * 查询教职工基础档案主
     * 
     * @param staffId 教职工基础档案主主键
     * @return 教职工基础档案主
     */
    @Override
    public StaffInfo selectStaffInfoByStaffId(String staffId)
    {
        return staffInfoMapper.selectStaffInfoByStaffId(staffId);
    }

    /**
     * 查询教职工基础档案主列表
     * 
     * @param staffInfo 教职工基础档案主
     * @return 教职工基础档案主
     */
    @Override
    public List<StaffInfo> selectStaffInfoList(StaffInfo staffInfo)
    {
        return staffInfoMapper.selectStaffInfoList(staffInfo);
    }

    /**
     * 新增教职工基础档案主
     * 
     * @param staffInfo 教职工基础档案主
     * @return 结果
     */
    @Override
    public int insertStaffInfo(StaffInfo staffInfo)
    {
        staffInfo.setCreateTime(DateUtils.getNowDate());
        return staffInfoMapper.insertStaffInfo(staffInfo);
    }

    /**
     * 修改教职工基础档案主
     * 
     * @param staffInfo 教职工基础档案主
     * @return 结果
     */
    @Override
    public int updateStaffInfo(StaffInfo staffInfo)
    {
        return staffInfoMapper.updateStaffInfo(staffInfo);
    }

    /**
     * 批量删除教职工基础档案主
     * 
     * @param staffIds 需要删除的教职工基础档案主主键
     * @return 结果
     */
    @Override
    public int deleteStaffInfoByStaffIds(String staffIds)
    {
        return staffInfoMapper.deleteStaffInfoByStaffIds(Convert.toStrArray(staffIds));
    }

    /**
     * 删除教职工基础档案主信息
     * 
     * @param staffId 教职工基础档案主主键
     * @return 结果
     */
    @Override
    public int deleteStaffInfoByStaffId(String staffId)
    {
        return staffInfoMapper.deleteStaffInfoByStaffId(staffId);
    }
}
