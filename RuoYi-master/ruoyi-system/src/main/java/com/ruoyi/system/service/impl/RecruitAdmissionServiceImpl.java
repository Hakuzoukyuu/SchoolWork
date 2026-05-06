package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RecruitAdmissionMapper;
import com.ruoyi.system.domain.RecruitAdmission;
import com.ruoyi.system.service.IRecruitAdmissionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 招生管理(志愿通过-未正式录取学生)Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class RecruitAdmissionServiceImpl implements IRecruitAdmissionService 
{
    @Autowired
    private RecruitAdmissionMapper recruitAdmissionMapper;

    /**
     * 查询招生管理(志愿通过-未正式录取学生)
     * 
     * @param id 招生管理(志愿通过-未正式录取学生)主键
     * @return 招生管理(志愿通过-未正式录取学生)
     */
    @Override
    public RecruitAdmission selectRecruitAdmissionById(Long id)
    {
        return recruitAdmissionMapper.selectRecruitAdmissionById(id);
    }

    /**
     * 查询招生管理(志愿通过-未正式录取学生)列表
     * 
     * @param recruitAdmission 招生管理(志愿通过-未正式录取学生)
     * @return 招生管理(志愿通过-未正式录取学生)
     */
    @Override
    public List<RecruitAdmission> selectRecruitAdmissionList(RecruitAdmission recruitAdmission)
    {
        return recruitAdmissionMapper.selectRecruitAdmissionList(recruitAdmission);
    }

    /**
     * 新增招生管理(志愿通过-未正式录取学生)
     * 
     * @param recruitAdmission 招生管理(志愿通过-未正式录取学生)
     * @return 结果
     */
    @Override
    public int insertRecruitAdmission(RecruitAdmission recruitAdmission)
    {
        recruitAdmission.setCreateTime(DateUtils.getNowDate());
        return recruitAdmissionMapper.insertRecruitAdmission(recruitAdmission);
    }

    /**
     * 修改招生管理(志愿通过-未正式录取学生)
     * 
     * @param recruitAdmission 招生管理(志愿通过-未正式录取学生)
     * @return 结果
     */
    @Override
    public int updateRecruitAdmission(RecruitAdmission recruitAdmission)
    {
        recruitAdmission.setUpdateTime(DateUtils.getNowDate());
        return recruitAdmissionMapper.updateRecruitAdmission(recruitAdmission);
    }

    /**
     * 批量删除招生管理(志愿通过-未正式录取学生)
     * 
     * @param ids 需要删除的招生管理(志愿通过-未正式录取学生)主键
     * @return 结果
     */
    @Override
    public int deleteRecruitAdmissionByIds(String ids)
    {
        return recruitAdmissionMapper.deleteRecruitAdmissionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除招生管理(志愿通过-未正式录取学生)信息
     * 
     * @param id 招生管理(志愿通过-未正式录取学生)主键
     * @return 结果
     */
    @Override
    public int deleteRecruitAdmissionById(Long id)
    {
        return recruitAdmissionMapper.deleteRecruitAdmissionById(id);
    }
}
