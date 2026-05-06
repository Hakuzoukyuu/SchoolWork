package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClubMemberMapper;
import com.ruoyi.system.domain.ClubMember;
import com.ruoyi.system.service.IClubMemberService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社团成员表Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class ClubMemberServiceImpl implements IClubMemberService 
{
    @Autowired
    private ClubMemberMapper clubMemberMapper;

    /**
     * 查询社团成员表
     * 
     * @param memberId 社团成员表主键
     * @return 社团成员表
     */
    @Override
    public ClubMember selectClubMemberByMemberId(Long memberId)
    {
        return clubMemberMapper.selectClubMemberByMemberId(memberId);
    }

    /**
     * 查询社团成员表列表
     * 
     * @param clubMember 社团成员表
     * @return 社团成员表
     */
    @Override
    public List<ClubMember> selectClubMemberList(ClubMember clubMember)
    {
        return clubMemberMapper.selectClubMemberList(clubMember);
    }

    /**
     * 新增社团成员表
     * 
     * @param clubMember 社团成员表
     * @return 结果
     */
    @Override
    public int insertClubMember(ClubMember clubMember)
    {
        clubMember.setCreateTime(DateUtils.getNowDate());
        return clubMemberMapper.insertClubMember(clubMember);
    }

    /**
     * 修改社团成员表
     * 
     * @param clubMember 社团成员表
     * @return 结果
     */
    @Override
    public int updateClubMember(ClubMember clubMember)
    {
        clubMember.setUpdateTime(DateUtils.getNowDate());
        return clubMemberMapper.updateClubMember(clubMember);
    }

    /**
     * 批量删除社团成员表
     * 
     * @param memberIds 需要删除的社团成员表主键
     * @return 结果
     */
    @Override
    public int deleteClubMemberByMemberIds(String memberIds)
    {
        return clubMemberMapper.deleteClubMemberByMemberIds(Convert.toStrArray(memberIds));
    }

    /**
     * 删除社团成员表信息
     * 
     * @param memberId 社团成员表主键
     * @return 结果
     */
    @Override
    public int deleteClubMemberByMemberId(Long memberId)
    {
        return clubMemberMapper.deleteClubMemberByMemberId(memberId);
    }
}
