package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentInternship;

/**
 * 企业实习(子)Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface StudentInternshipMapper 
{
    /**
     * 查询企业实习(子)
     * 
     * @param internshipId 企业实习(子)主键
     * @return 企业实习(子)
     */
    public StudentInternship selectStudentInternshipByInternshipId(String internshipId);

    /**
     * 查询企业实习(子)列表
     * 
     * @param studentInternship 企业实习(子)
     * @return 企业实习(子)集合
     */
    public List<StudentInternship> selectStudentInternshipList(StudentInternship studentInternship);

    /**
     * 新增企业实习(子)
     * 
     * @param studentInternship 企业实习(子)
     * @return 结果
     */
    public int insertStudentInternship(StudentInternship studentInternship);

    /**
     * 修改企业实习(子)
     * 
     * @param studentInternship 企业实习(子)
     * @return 结果
     */
    public int updateStudentInternship(StudentInternship studentInternship);

    /**
     * 删除企业实习(子)
     * 
     * @param internshipId 企业实习(子)主键
     * @return 结果
     */
    public int deleteStudentInternshipByInternshipId(String internshipId);

    /**
     * 批量删除企业实习(子)
     * 
     * @param internshipIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentInternshipByInternshipIds(String[] internshipIds);
}
