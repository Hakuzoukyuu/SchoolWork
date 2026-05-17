package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StudentDorm;

/**
 * 住宿信息Service接口
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
public interface IStudentDormService 
{
    /**
     * 查询住宿信息
     * 
     * @param dormId 住宿信息主键
     * @return 住宿信息
     */
    public StudentDorm selectStudentDormByDormId(Long dormId);

    /**
     * 查询住宿信息列表
     * 
     * @param studentDorm 住宿信息
     * @return 住宿信息集合
     */
    public List<StudentDorm> selectStudentDormList(StudentDorm studentDorm);

    /**
     * 新增住宿信息
     * 
     * @param studentDorm 住宿信息
     * @return 结果
     */
    public int insertStudentDorm(StudentDorm studentDorm);

    /**
     * 修改住宿信息
     * 
     * @param studentDorm 住宿信息
     * @return 结果
     */
    public int updateStudentDorm(StudentDorm studentDorm);

    /**
     * 批量删除住宿信息
     * 
     * @param dormIds 需要删除的住宿信息主键集合
     * @return 结果
     */
    public int deleteStudentDormByDormIds(String dormIds);

    /**
     * 删除住宿信息信息
     * 
     * @param dormId 住宿信息主键
     * @return 结果
     */
    public int deleteStudentDormByDormId(Long dormId);
}
