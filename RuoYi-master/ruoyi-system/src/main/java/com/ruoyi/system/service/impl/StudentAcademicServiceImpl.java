package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentAcademicMapper;
import com.ruoyi.system.domain.StudentAcademic;
import com.ruoyi.system.service.IStudentAcademicService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学籍信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
@Service
public class StudentAcademicServiceImpl implements IStudentAcademicService 
{
    @Autowired
    private StudentAcademicMapper studentAcademicMapper;

    /**
     * 查询学籍信息
     * 
     * @param academicId 学籍信息主键
     * @return 学籍信息
     */
    @Override
    public StudentAcademic selectStudentAcademicByAcademicId(Long academicId)
    {
        return studentAcademicMapper.selectStudentAcademicByAcademicId(academicId);
    }

    /**
     * 查询学籍信息列表
     * 
     * @param studentAcademic 学籍信息
     * @return 学籍信息
     */
    @Override
    public List<StudentAcademic> selectStudentAcademicList(StudentAcademic studentAcademic)
    {
        return studentAcademicMapper.selectStudentAcademicList(studentAcademic);
    }

    /**
     * 新增学籍信息
     * 
     * @param studentAcademic 学籍信息
     * @return 结果
     */
    @Override
    public int insertStudentAcademic(StudentAcademic studentAcademic)
    {
        return studentAcademicMapper.insertStudentAcademic(studentAcademic);
    }

    /**
     * 修改学籍信息
     * 
     * @param studentAcademic 学籍信息
     * @return 结果
     */
    @Override
    public int updateStudentAcademic(StudentAcademic studentAcademic)
    {
        return studentAcademicMapper.updateStudentAcademic(studentAcademic);
    }

    /**
     * 批量删除学籍信息
     * 
     * @param academicIds 需要删除的学籍信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentAcademicByAcademicIds(String academicIds)
    {
        return studentAcademicMapper.deleteStudentAcademicByAcademicIds(Convert.toStrArray(academicIds));
    }

    /**
     * 删除学籍信息信息
     * 
     * @param academicId 学籍信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentAcademicByAcademicId(Long academicId)
    {
        return studentAcademicMapper.deleteStudentAcademicByAcademicId(academicId);
    }
}
