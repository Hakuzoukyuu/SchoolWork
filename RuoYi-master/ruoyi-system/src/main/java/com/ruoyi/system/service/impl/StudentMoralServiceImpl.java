package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentMoralMapper;
import com.ruoyi.system.domain.StudentMoral;
import com.ruoyi.system.service.IStudentMoralService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生德育考核管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class StudentMoralServiceImpl implements IStudentMoralService 
{
    @Autowired
    private StudentMoralMapper studentMoralMapper;

    /**
     * 查询学生德育考核管理
     * 
     * @param studentId 学生德育考核管理主键
     * @return 学生德育考核管理
     */
    @Override
    public StudentMoral selectStudentMoralByStudentId(String studentId)
    {
        return studentMoralMapper.selectStudentMoralByStudentId(studentId);
    }

    /**
     * 查询学生德育考核管理列表
     * 
     * @param studentMoral 学生德育考核管理
     * @return 学生德育考核管理
     */
    @Override
    public List<StudentMoral> selectStudentMoralList(StudentMoral studentMoral)
    {
        return studentMoralMapper.selectStudentMoralList(studentMoral);
    }

    /**
     * 新增学生德育考核管理
     * 
     * @param studentMoral 学生德育考核管理
     * @return 结果
     */
    @Override
    public int insertStudentMoral(StudentMoral studentMoral)
    {
        studentMoral.setCreateTime(DateUtils.getNowDate());
        return studentMoralMapper.insertStudentMoral(studentMoral);
    }

    /**
     * 修改学生德育考核管理
     * 
     * @param studentMoral 学生德育考核管理
     * @return 结果
     */
    @Override
    public int updateStudentMoral(StudentMoral studentMoral)
    {
        studentMoral.setUpdateTime(DateUtils.getNowDate());
        return studentMoralMapper.updateStudentMoral(studentMoral);
    }

    /**
     * 批量删除学生德育考核管理
     * 
     * @param studentIds 需要删除的学生德育考核管理主键
     * @return 结果
     */
    @Override
    public int deleteStudentMoralByStudentIds(String studentIds)
    {
        return studentMoralMapper.deleteStudentMoralByStudentIds(Convert.toStrArray(studentIds));
    }

    /**
     * 删除学生德育考核管理信息
     * 
     * @param studentId 学生德育考核管理主键
     * @return 结果
     */
    @Override
    public int deleteStudentMoralByStudentId(String studentId)
    {
        return studentMoralMapper.deleteStudentMoralByStudentId(studentId);
    }
}
