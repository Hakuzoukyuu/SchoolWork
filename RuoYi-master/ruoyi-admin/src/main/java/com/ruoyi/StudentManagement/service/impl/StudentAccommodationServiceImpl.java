package com.ruoyi.StudentManagement.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.StudentManagement.mapper.StudentAccommodationMapper;
import com.ruoyi.StudentManagement.domain.StudentAccommodation;
import com.ruoyi.StudentManagement.service.IStudentAccommodationService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生住宿信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
@Service
public class StudentAccommodationServiceImpl implements IStudentAccommodationService 
{
    @Autowired
    private StudentAccommodationMapper studentAccommodationMapper;

    /**
     * 查询学生住宿信息
     * 
     * @param accommodationId 学生住宿信息主键
     * @return 学生住宿信息
     */
    @Override
    public StudentAccommodation selectStudentAccommodationByAccommodationId(Long accommodationId)
    {
        return studentAccommodationMapper.selectStudentAccommodationByAccommodationId(accommodationId);
    }

    /**
     * 查询学生住宿信息列表
     * 
     * @param studentAccommodation 学生住宿信息
     * @return 学生住宿信息
     */
    @Override
    public List<StudentAccommodation> selectStudentAccommodationList(StudentAccommodation studentAccommodation)
    {
        return studentAccommodationMapper.selectStudentAccommodationList(studentAccommodation);
    }

    /**
     * 新增学生住宿信息
     * 
     * @param studentAccommodation 学生住宿信息
     * @return 结果
     */
    @Override
    public int insertStudentAccommodation(StudentAccommodation studentAccommodation)
    {
        return studentAccommodationMapper.insertStudentAccommodation(studentAccommodation);
    }

    /**
     * 修改学生住宿信息
     * 
     * @param studentAccommodation 学生住宿信息
     * @return 结果
     */
    @Override
    public int updateStudentAccommodation(StudentAccommodation studentAccommodation)
    {
        return studentAccommodationMapper.updateStudentAccommodation(studentAccommodation);
    }

    /**
     * 批量删除学生住宿信息
     * 
     * @param accommodationIds 需要删除的学生住宿信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentAccommodationByAccommodationIds(String accommodationIds)
    {
        return studentAccommodationMapper.deleteStudentAccommodationByAccommodationIds(Convert.toStrArray(accommodationIds));
    }

    /**
     * 删除学生住宿信息信息
     * 
     * @param accommodationId 学生住宿信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentAccommodationByAccommodationId(Long accommodationId)
    {
        return studentAccommodationMapper.deleteStudentAccommodationByAccommodationId(accommodationId);
    }
}
