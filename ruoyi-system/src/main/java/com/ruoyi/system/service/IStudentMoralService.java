package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StudentMoral;

/**
 * 学生德育考核管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IStudentMoralService 
{
    /**
     * 查询学生德育考核管理
     * 
     * @param studentId 学生德育考核管理主键
     * @return 学生德育考核管理
     */
    public StudentMoral selectStudentMoralByStudentId(String studentId);

    /**
     * 查询学生德育考核管理列表
     * 
     * @param studentMoral 学生德育考核管理
     * @return 学生德育考核管理集合
     */
    public List<StudentMoral> selectStudentMoralList(StudentMoral studentMoral);

    /**
     * 新增学生德育考核管理
     * 
     * @param studentMoral 学生德育考核管理
     * @return 结果
     */
    public int insertStudentMoral(StudentMoral studentMoral);

    /**
     * 修改学生德育考核管理
     * 
     * @param studentMoral 学生德育考核管理
     * @return 结果
     */
    public int updateStudentMoral(StudentMoral studentMoral);

    /**
     * 批量删除学生德育考核管理
     * 
     * @param studentIds 需要删除的学生德育考核管理主键集合
     * @return 结果
     */
    public int deleteStudentMoralByStudentIds(String studentIds);

    /**
     * 删除学生德育考核管理信息
     * 
     * @param studentId 学生德育考核管理主键
     * @return 结果
     */
    public int deleteStudentMoralByStudentId(String studentId);
}
