package com.ruoyi.StudentManagement.mapper;

import java.util.List;
import com.ruoyi.StudentManagement.domain.StudentAccommodation;

/**
 * 学生住宿信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
public interface StudentAccommodationMapper 
{
    /**
     * 查询学生住宿信息
     * 
     * @param accommodationId 学生住宿信息主键
     * @return 学生住宿信息
     */
    public StudentAccommodation selectStudentAccommodationByAccommodationId(Long accommodationId);

    /**
     * 查询学生住宿信息列表
     * 
     * @param studentAccommodation 学生住宿信息
     * @return 学生住宿信息集合
     */
    public List<StudentAccommodation> selectStudentAccommodationList(StudentAccommodation studentAccommodation);

    /**
     * 新增学生住宿信息
     * 
     * @param studentAccommodation 学生住宿信息
     * @return 结果
     */
    public int insertStudentAccommodation(StudentAccommodation studentAccommodation);

    /**
     * 修改学生住宿信息
     * 
     * @param studentAccommodation 学生住宿信息
     * @return 结果
     */
    public int updateStudentAccommodation(StudentAccommodation studentAccommodation);

    /**
     * 删除学生住宿信息
     * 
     * @param accommodationId 学生住宿信息主键
     * @return 结果
     */
    public int deleteStudentAccommodationByAccommodationId(Long accommodationId);

    /**
     * 批量删除学生住宿信息
     * 
     * @param accommodationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentAccommodationByAccommodationIds(String[] accommodationIds);
}
