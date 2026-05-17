package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StaffAttendanceMapper;
import com.ruoyi.system.domain.StaffAttendance;
import com.ruoyi.system.service.IStaffAttendanceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class StaffAttendanceServiceImpl implements IStaffAttendanceService 
{
    @Autowired
    private StaffAttendanceMapper staffAttendanceMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param attenId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public StaffAttendance selectStaffAttendanceByAttenId(Long attenId)
    {
        return staffAttendanceMapper.selectStaffAttendanceByAttenId(attenId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param staffAttendance 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<StaffAttendance> selectStaffAttendanceList(StaffAttendance staffAttendance)
    {
        return staffAttendanceMapper.selectStaffAttendanceList(staffAttendance);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param staffAttendance 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertStaffAttendance(StaffAttendance staffAttendance)
    {
        return staffAttendanceMapper.insertStaffAttendance(staffAttendance);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param staffAttendance 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateStaffAttendance(StaffAttendance staffAttendance)
    {
        return staffAttendanceMapper.updateStaffAttendance(staffAttendance);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param attenIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteStaffAttendanceByAttenIds(String attenIds)
    {
        return staffAttendanceMapper.deleteStaffAttendanceByAttenIds(Convert.toStrArray(attenIds));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param attenId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteStaffAttendanceByAttenId(Long attenId)
    {
        return staffAttendanceMapper.deleteStaffAttendanceByAttenId(attenId);
    }
}
