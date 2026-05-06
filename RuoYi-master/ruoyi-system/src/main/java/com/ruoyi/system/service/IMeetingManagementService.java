package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.MeetingManagement;

/**
 * 会议管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IMeetingManagementService 
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
     * 批量删除会议管理
     * 
     * @param meetingIds 需要删除的会议管理主键集合
     * @return 结果
     */
    public int deleteMeetingManagementByMeetingIds(String meetingIds);

    /**
     * 删除会议管理信息
     * 
     * @param meetingId 会议管理主键
     * @return 结果
     */
    public int deleteMeetingManagementByMeetingId(Long meetingId);
}
