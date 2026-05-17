package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RecruitAdmission;

/**
 * 招生管理(志愿通过-未正式录取学生)Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface RecruitAdmissionMapper 
{
    /**
     * 查询招生管理(志愿通过-未正式录取学生)
     * 
     * @param id 招生管理(志愿通过-未正式录取学生)主键
     * @return 招生管理(志愿通过-未正式录取学生)
     */
    public RecruitAdmission selectRecruitAdmissionById(Long id);

    /**
     * 查询招生管理(志愿通过-未正式录取学生)列表
     * 
     * @param recruitAdmission 招生管理(志愿通过-未正式录取学生)
     * @return 招生管理(志愿通过-未正式录取学生)集合
     */
    public List<RecruitAdmission> selectRecruitAdmissionList(RecruitAdmission recruitAdmission);

    /**
     * 新增招生管理(志愿通过-未正式录取学生)
     * 
     * @param recruitAdmission 招生管理(志愿通过-未正式录取学生)
     * @return 结果
     */
    public int insertRecruitAdmission(RecruitAdmission recruitAdmission);

    /**
     * 修改招生管理(志愿通过-未正式录取学生)
     * 
     * @param recruitAdmission 招生管理(志愿通过-未正式录取学生)
     * @return 结果
     */
    public int updateRecruitAdmission(RecruitAdmission recruitAdmission);

    /**
     * 删除招生管理(志愿通过-未正式录取学生)
     * 
     * @param id 招生管理(志愿通过-未正式录取学生)主键
     * @return 结果
     */
    public int deleteRecruitAdmissionById(Long id);

    /**
     * 批量删除招生管理(志愿通过-未正式录取学生)
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecruitAdmissionByIds(String[] ids);
}
