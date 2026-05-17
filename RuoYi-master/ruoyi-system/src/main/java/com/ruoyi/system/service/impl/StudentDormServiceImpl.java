package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentDormMapper;
import com.ruoyi.system.domain.StudentDorm;
import com.ruoyi.system.service.IStudentDormService;
import com.ruoyi.common.core.text.Convert;

/**
 * 住宿信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
@Service
public class StudentDormServiceImpl implements IStudentDormService 
{
    @Autowired
    private StudentDormMapper studentDormMapper;

    /**
     * 查询住宿信息
     * 
     * @param dormId 住宿信息主键
     * @return 住宿信息
     */
    @Override
    public StudentDorm selectStudentDormByDormId(Long dormId)
    {
        return studentDormMapper.selectStudentDormByDormId(dormId);
    }

    /**
     * 查询住宿信息列表
     * 
     * @param studentDorm 住宿信息
     * @return 住宿信息
     */
    @Override
    public List<StudentDorm> selectStudentDormList(StudentDorm studentDorm)
    {
        return studentDormMapper.selectStudentDormList(studentDorm);
    }

    /**
     * 新增住宿信息
     * 
     * @param studentDorm 住宿信息
     * @return 结果
     */
    @Override
    public int insertStudentDorm(StudentDorm studentDorm)
    {
        return studentDormMapper.insertStudentDorm(studentDorm);
    }

    /**
     * 修改住宿信息
     * 
     * @param studentDorm 住宿信息
     * @return 结果
     */
    @Override
    public int updateStudentDorm(StudentDorm studentDorm)
    {
        return studentDormMapper.updateStudentDorm(studentDorm);
    }

    /**
     * 批量删除住宿信息
     * 
     * @param dormIds 需要删除的住宿信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentDormByDormIds(String dormIds)
    {
        return studentDormMapper.deleteStudentDormByDormIds(Convert.toStrArray(dormIds));
    }

    /**
     * 删除住宿信息信息
     * 
     * @param dormId 住宿信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentDormByDormId(Long dormId)
    {
        return studentDormMapper.deleteStudentDormByDormId(dormId);
    }
}
