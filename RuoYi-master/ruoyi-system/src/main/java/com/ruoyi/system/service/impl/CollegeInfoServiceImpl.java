package com.ruoyi.CollegeManagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.CollegeManagement.mapper.CollegeInfoMapper;
import com.ruoyi.CollegeManagement.domain.CollegeInfo;
import com.ruoyi.CollegeManagement.service.ICollegeInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学院信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
@Service
public class CollegeInfoServiceImpl implements ICollegeInfoService 
{
    @Autowired
    private CollegeInfoMapper collegeInfoMapper;

    /**
     * 查询学院信息
     * 
     * @param collegeId 学院信息主键
     * @return 学院信息
     */
    @Override
    public CollegeInfo selectCollegeInfoByCollegeId(Long collegeId)
    {
        return collegeInfoMapper.selectCollegeInfoByCollegeId(collegeId);
    }

    /**
     * 查询学院信息列表
     * 
     * @param collegeInfo 学院信息
     * @return 学院信息
     */
    @Override
    public List<CollegeInfo> selectCollegeInfoList(CollegeInfo collegeInfo)
    {
        return collegeInfoMapper.selectCollegeInfoList(collegeInfo);
    }

    /**
     * 新增学院信息
     * 
     * @param collegeInfo 学院信息
     * @return 结果
     */
    @Override
    public int insertCollegeInfo(CollegeInfo collegeInfo)
    {
        return collegeInfoMapper.insertCollegeInfo(collegeInfo);
    }

    /**
     * 修改学院信息
     * 
     * @param collegeInfo 学院信息
     * @return 结果
     */
    @Override
    public int updateCollegeInfo(CollegeInfo collegeInfo)
    {
        return collegeInfoMapper.updateCollegeInfo(collegeInfo);
    }

    /**
     * 批量删除学院信息
     * 
     * @param collegeIds 需要删除的学院信息主键
     * @return 结果
     */
    @Override
    public int deleteCollegeInfoByCollegeIds(String collegeIds)
    {
        return collegeInfoMapper.deleteCollegeInfoByCollegeIds(Convert.toStrArray(collegeIds));
    }

    /**
     * 删除学院信息信息
     * 
     * @param collegeId 学院信息主键
     * @return 结果
     */
    @Override
    public int deleteCollegeInfoByCollegeId(Long collegeId)
    {
        return collegeInfoMapper.deleteCollegeInfoByCollegeId(collegeId);
    }
}
