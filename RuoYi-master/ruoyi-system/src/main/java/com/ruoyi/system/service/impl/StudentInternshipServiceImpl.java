package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentInternshipMapper;
import com.ruoyi.system.domain.StudentInternship;
import com.ruoyi.system.service.IStudentInternshipService;
import com.ruoyi.common.core.text.Convert;

/**
 * 企业实习(子)Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class StudentInternshipServiceImpl implements IStudentInternshipService 
{
    @Autowired
    private StudentInternshipMapper studentInternshipMapper;

    /**
     * 查询企业实习(子)
     * 
     * @param internshipId 企业实习(子)主键
     * @return 企业实习(子)
     */
    @Override
    public StudentInternship selectStudentInternshipByInternshipId(String internshipId)
    {
        return studentInternshipMapper.selectStudentInternshipByInternshipId(internshipId);
    }

    /**
     * 查询企业实习(子)列表
     * 
     * @param studentInternship 企业实习(子)
     * @return 企业实习(子)
     */
    @Override
    public List<StudentInternship> selectStudentInternshipList(StudentInternship studentInternship)
    {
        return studentInternshipMapper.selectStudentInternshipList(studentInternship);
    }

    /**
     * 新增企业实习(子)
     * 
     * @param studentInternship 企业实习(子)
     * @return 结果
     */
    @Override
    public int insertStudentInternship(StudentInternship studentInternship)
    {
        studentInternship.setCreateTime(DateUtils.getNowDate());
        return studentInternshipMapper.insertStudentInternship(studentInternship);
    }

    /**
     * 修改企业实习(子)
     * 
     * @param studentInternship 企业实习(子)
     * @return 结果
     */
    @Override
    public int updateStudentInternship(StudentInternship studentInternship)
    {
        studentInternship.setUpdateTime(DateUtils.getNowDate());
        return studentInternshipMapper.updateStudentInternship(studentInternship);
    }

    /**
     * 批量删除企业实习(子)
     * 
     * @param internshipIds 需要删除的企业实习(子)主键
     * @return 结果
     */
    @Override
    public int deleteStudentInternshipByInternshipIds(String internshipIds)
    {
        return studentInternshipMapper.deleteStudentInternshipByInternshipIds(Convert.toStrArray(internshipIds));
    }

    /**
     * 删除企业实习(子)信息
     * 
     * @param internshipId 企业实习(子)主键
     * @return 结果
     */
    @Override
    public int deleteStudentInternshipByInternshipId(String internshipId)
    {
        return studentInternshipMapper.deleteStudentInternshipByInternshipId(internshipId);
    }
}
