package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StaffAttendance;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface StaffAttendanceMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param attenId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public StaffAttendance selectStaffAttendanceByAttenId(Long attenId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param staffAttendance 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<StaffAttendance> selectStaffAttendanceList(StaffAttendance staffAttendance);

    /**
     * 新增【请填写功能名称】
     * 
     * @param staffAttendance 【请填写功能名称】
     * @return 结果
     */
    public int insertStaffAttendance(StaffAttendance staffAttendance);

    /**
     * 修改【请填写功能名称】
     * 
     * @param staffAttendance 【请填写功能名称】
     * @return 结果
     */
    public int updateStaffAttendance(StaffAttendance staffAttendance);

    /**
     * 删除【请填写功能名称】
     * 
     * @param attenId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteStaffAttendanceByAttenId(Long attenId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param attenIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStaffAttendanceByAttenIds(String[] attenIds);
}
