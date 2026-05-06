package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ClubMember;

/**
 * 社团成员表Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface ClubMemberMapper 
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
     * 删除社团成员表
     * 
     * @param memberId 社团成员表主键
     * @return 结果
     */
    public int deleteClubMemberByMemberId(Long memberId);

    /**
     * 批量删除社团成员表
     * 
     * @param memberIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClubMemberByMemberIds(String[] memberIds);
}
