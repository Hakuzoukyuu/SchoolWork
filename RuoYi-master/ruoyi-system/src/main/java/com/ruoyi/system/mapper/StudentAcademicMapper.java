package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentAcademic;

/**
 * 学籍信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
public interface StudentAcademicMapper 
{
    /**
     * 查询学籍信息
     * 
     * @param academicId 学籍信息主键
     * @return 学籍信息
     */
    public StudentAcademic selectStudentAcademicByAcademicId(Long academicId);

    /**
     * 查询学籍信息列表
     * 
     * @param studentAcademic 学籍信息
     * @return 学籍信息集合
     */
    public List<StudentAcademic> selectStudentAcademicList(StudentAcademic studentAcademic);

    /**
     * 新增学籍信息
     * 
     * @param studentAcademic 学籍信息
     * @return 结果
     */
    public int insertStudentAcademic(StudentAcademic studentAcademic);

    /**
     * 修改学籍信息
     * 
     * @param studentAcademic 学籍信息
     * @return 结果
     */
    public int updateStudentAcademic(StudentAcademic studentAcademic);

    /**
     * 删除学籍信息
     * 
     * @param academicId 学籍信息主键
     * @return 结果
     */
    public int deleteStudentAcademicByAcademicId(Long academicId);

    /**
     * 批量删除学籍信息
     * 
     * @param academicIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentAcademicByAcademicIds(String[] academicIds);
}
