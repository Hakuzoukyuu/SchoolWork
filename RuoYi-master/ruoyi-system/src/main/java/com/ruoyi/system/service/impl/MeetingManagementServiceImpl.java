package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.MeetingManagementMapper;
import com.ruoyi.system.domain.MeetingManagement;
import com.ruoyi.system.service.IMeetingManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 会议管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class MeetingManagementServiceImpl implements IMeetingManagementService 
{
    @Autowired
    private MeetingManagementMapper meetingManagementMapper;

    /**
     * 查询会议管理
     * 
     * @param meetingId 会议管理主键
     * @return 会议管理
     */
    @Override
    public MeetingManagement selectMeetingManagementByMeetingId(Long meetingId)
    {
        return meetingManagementMapper.selectMeetingManagementByMeetingId(meetingId);
    }

    /**
     * 查询会议管理列表
     * 
     * @param meetingManagement 会议管理
     * @return 会议管理
     */
    @Override
    public List<MeetingManagement> selectMeetingManagementList(MeetingManagement meetingManagement)
    {
        return meetingManagementMapper.selectMeetingManagementList(meetingManagement);
    }

    /**
     * 新增会议管理
     * 
     * @param meetingManagement 会议管理
     * @return 结果
     */
    @Override
    public int insertMeetingManagement(MeetingManagement meetingManagement)
    {
        meetingManagement.setCreateTime(DateUtils.getNowDate());
        return meetingManagementMapper.insertMeetingManagement(meetingManagement);
    }

    /**
     * 修改会议管理
     * 
     * @param meetingManagement 会议管理
     * @return 结果
     */
    @Override
    public int updateMeetingManagement(MeetingManagement meetingManagement)
    {
        meetingManagement.setUpdateTime(DateUtils.getNowDate());
        return meetingManagementMapper.updateMeetingManagement(meetingManagement);
    }

    /**
     * 批量删除会议管理
     * 
     * @param meetingIds 需要删除的会议管理主键
     * @return 结果
     */
    @Override
    public int deleteMeetingManagementByMeetingIds(String meetingIds)
    {
        return meetingManagementMapper.deleteMeetingManagementByMeetingIds(Convert.toStrArray(meetingIds));
    }

    /**
     * 删除会议管理信息
     * 
     * @param meetingId 会议管理主键
     * @return 结果
     */
    @Override
    public int deleteMeetingManagementByMeetingId(Long meetingId)
    {
        return meetingManagementMapper.deleteMeetingManagementByMeetingId(meetingId);
    }
}
