package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.domain.ClubMember;

/**
 * 社团管理Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface ClubMapper 
{
    /**
     * 查询社团管理
     * 
     * @param clubId 社团管理主键
     * @return 社团管理
     */
    public Club selectClubByClubId(Long clubId);

    /**
     * 查询社团管理列表
     * 
     * @param club 社团管理
     * @return 社团管理集合
     */
    public List<Club> selectClubList(Club club);

    /**
     * 新增社团管理
     * 
     * @param club 社团管理
     * @return 结果
     */
    public int insertClub(Club club);

    /**
     * 修改社团管理
     * 
     * @param club 社团管理
     * @return 结果
     */
    public int updateClub(Club club);

    /**
     * 删除社团管理
     * 
     * @param clubId 社团管理主键
     * @return 结果
     */
    public int deleteClubByClubId(Long clubId);

    /**
     * 批量删除社团管理
     * 
     * @param clubIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClubByClubIds(String[] clubIds);

    /**
     * 批量删除社团成员表
     * 
     * @param clubIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClubMemberByClubIds(String[] clubIds);
    
    /**
     * 批量新增社团成员表
     * 
     * @param clubMemberList 社团成员表列表
     * @return 结果
     */
    public int batchClubMember(List<ClubMember> clubMemberList);
    

    /**
     * 通过社团管理主键删除社团成员表信息
     * 
     * @param clubId 社团管理ID
     * @return 结果
     */
    public int deleteClubMemberByClubId(Long clubId);
}
