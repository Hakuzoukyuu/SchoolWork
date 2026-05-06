package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.ClubMember;
import com.ruoyi.system.mapper.ClubMapper;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.service.IClubService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社团管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class ClubServiceImpl implements IClubService 
{
    @Autowired
    private ClubMapper clubMapper;

    /**
     * 查询社团管理
     * 
     * @param clubId 社团管理主键
     * @return 社团管理
     */
    @Override
    public Club selectClubByClubId(Long clubId)
    {
        return clubMapper.selectClubByClubId(clubId);
    }

    /**
     * 查询社团管理列表
     * 
     * @param club 社团管理
     * @return 社团管理
     */
    @Override
    public List<Club> selectClubList(Club club)
    {
        return clubMapper.selectClubList(club);
    }

    /**
     * 新增社团管理
     * 
     * @param club 社团管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertClub(Club club)
    {
        club.setCreateTime(DateUtils.getNowDate());
        int rows = clubMapper.insertClub(club);
        insertClubMember(club);
        return rows;
    }

    /**
     * 修改社团管理
     * 
     * @param club 社团管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateClub(Club club)
    {
        club.setUpdateTime(DateUtils.getNowDate());
        clubMapper.deleteClubMemberByClubId(club.getClubId());
        insertClubMember(club);
        return clubMapper.updateClub(club);
    }

    /**
     * 批量删除社团管理
     * 
     * @param clubIds 需要删除的社团管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteClubByClubIds(String clubIds)
    {
        clubMapper.deleteClubMemberByClubIds(Convert.toStrArray(clubIds));
        return clubMapper.deleteClubByClubIds(Convert.toStrArray(clubIds));
    }

    /**
     * 删除社团管理信息
     * 
     * @param clubId 社团管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteClubByClubId(Long clubId)
    {
        clubMapper.deleteClubMemberByClubId(clubId);
        return clubMapper.deleteClubByClubId(clubId);
    }

    /**
     * 新增社团成员表信息
     * 
     * @param club 社团管理对象
     */
    public void insertClubMember(Club club)
    {
        List<ClubMember> clubMemberList = club.getClubMemberList();
        Long clubId = club.getClubId();
        if (StringUtils.isNotNull(clubMemberList))
        {
            List<ClubMember> list = new ArrayList<ClubMember>();
            for (ClubMember clubMember : clubMemberList)
            {
                clubMember.setClubId(clubId);
                list.add(clubMember);
            }
            if (list.size() > 0)
            {
                clubMapper.batchClubMember(list);
            }
        }
    }
}
