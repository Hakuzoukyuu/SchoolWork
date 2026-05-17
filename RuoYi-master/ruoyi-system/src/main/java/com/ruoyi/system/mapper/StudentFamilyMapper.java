package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentFamily;

/**
 * 家庭信息Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
public interface StudentFamilyMapper 
{
    /**
     * 查询家庭信息
     * 
     * @param familyId 家庭信息主键
     * @return 家庭信息
     */
    public StudentFamily selectStudentFamilyByFamilyId(Long familyId);

    /**
     * 查询家庭信息列表
     * 
     * @param studentFamily 家庭信息
     * @return 家庭信息集合
     */
    public List<StudentFamily> selectStudentFamilyList(StudentFamily studentFamily);

    /**
     * 新增家庭信息
     * 
     * @param studentFamily 家庭信息
     * @return 结果
     */
    public int insertStudentFamily(StudentFamily studentFamily);

    /**
     * 修改家庭信息
     * 
     * @param studentFamily 家庭信息
     * @return 结果
     */
    public int updateStudentFamily(StudentFamily studentFamily);

    /**
     * 删除家庭信息
     * 
     * @param familyId 家庭信息主键
     * @return 结果
     */
    public int deleteStudentFamilyByFamilyId(Long familyId);

    /**
     * 批量删除家庭信息
     * 
     * @param familyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentFamilyByFamilyIds(String[] familyIds);
}
