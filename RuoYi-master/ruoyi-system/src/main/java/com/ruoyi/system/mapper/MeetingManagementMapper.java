package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.MeetingManagement;

/**
 * 会议管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface MeetingManagementMapper 
{
    /**
     * 查询会议管理
     * 
     * @param meetingId 会议管理主键
     * @return 会议管理
     */
    public MeetingManagement selectMeetingManagementByMeetingId(Long meetingId);

    /**
     * 查询会议管理列表
     * 
     * @param meetingManagement 会议管理
     * @return 会议管理集合
     */
    public List<MeetingManagement> selectMeetingManagementList(MeetingManagement meetingManagement);

    /**
     * 新增会议管理
     * 
     * @param meetingManagement 会议管理
     * @return 结果
     */
    public int insertMeetingManagement(MeetingManagement meetingManagement);

    /**
     * 修改会议管理
     * 
     * @param meetingManagement 会议管理
     * @return 结果
     */
    public int updateMeetingManagement(MeetingManagement meetingManagement);

    /**
     * 删除会议管理
     * 
     * @param meetingId 会议管理主键
     * @return 结果
     */
    public int deleteMeetingManagementByMeetingId(Long meetingId);

    /**
     * 批量删除会议管理
     * 
     * @param meetingIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMeetingManagementByMeetingIds(String[] meetingIds);
}
