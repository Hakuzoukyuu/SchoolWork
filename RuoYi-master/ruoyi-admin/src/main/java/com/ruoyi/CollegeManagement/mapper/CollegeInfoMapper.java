package com.ruoyi.CollegeManagement.mapper;

import java.util.List;
import com.ruoyi.CollegeManagement.domain.CollegeInfo;

/**
 * 学院信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
public interface CollegeInfoMapper 
{
    /**
     * 查询学院信息
     * 
     * @param collegeId 学院信息主键
     * @return 学院信息
     */
    public CollegeInfo selectCollegeInfoByCollegeId(Long collegeId);

    /**
     * 查询学院信息列表
     * 
     * @param collegeInfo 学院信息
     * @return 学院信息集合
     */
    public List<CollegeInfo> selectCollegeInfoList(CollegeInfo collegeInfo);

    /**
     * 新增学院信息
     * 
     * @param collegeInfo 学院信息
     * @return 结果
     */
    public int insertCollegeInfo(CollegeInfo collegeInfo);

    /**
     * 修改学院信息
     * 
     * @param collegeInfo 学院信息
     * @return 结果
     */
    public int updateCollegeInfo(CollegeInfo collegeInfo);

    /**
     * 删除学院信息
     * 
     * @param collegeId 学院信息主键
     * @return 结果
     */
    public int deleteCollegeInfoByCollegeId(Long collegeId);

    /**
     * 批量删除学院信息
     * 
     * @param collegeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCollegeInfoByCollegeIds(String[] collegeIds);
}
