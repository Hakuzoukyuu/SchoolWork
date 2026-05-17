package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentDorm;

/**
 * 住宿信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
public interface StudentDormMapper 
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
     * 删除住宿信息
     * 
     * @param dormId 住宿信息主键
     * @return 结果
     */
    public int deleteStudentDormByDormId(Long dormId);

    /**
     * 批量删除住宿信息
     * 
     * @param dormIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentDormByDormIds(String[] dormIds);
}
