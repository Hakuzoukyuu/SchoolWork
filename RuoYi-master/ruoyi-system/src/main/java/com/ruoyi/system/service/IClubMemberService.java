package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ClubMember;

/**
 * 社团成员表Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IClubMemberService 
{
    /**
     * 查询社团成员表
     * 
     * @param memberId 社团成员表主键
     * @return 社团成员表
     */
    public ClubMember selectClubMemberByMemberId(Long memberId);

    /**
     * 查询社团成员表列表
     * 
     * @param clubMember 社团成员表
     * @return 社团成员表集合
     */
    public List<ClubMember> selectClubMemberList(ClubMember clubMember);

    /**
     * 新增社团成员表
     * 
     * @param clubMember 社团成员表
     * @return 结果
     */
    public int insertClubMember(ClubMember clubMember);

    /**
     * 修改社团成员表
     * 
     * @param clubMember 社团成员表
     * @return 结果
     */
    public int updateClubMember(ClubMember clubMember);

    /**
     * 批量删除社团成员表
     * 
     * @param memberIds 需要删除的社团成员表主键集合
     * @return 结果
     */
    public int deleteClubMemberByMemberIds(String memberIds);

    /**
     * 删除社团成员表信息
     * 
     * @param memberId 社团成员表主键
     * @return 结果
     */
    public int deleteClubMemberByMemberId(Long memberId);
}
