package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentFamilyMapper;
import com.ruoyi.system.domain.StudentFamily;
import com.ruoyi.system.service.IStudentFamilyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 家庭信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
@Service
public class StudentFamilyServiceImpl implements IStudentFamilyService 
{
    @Autowired
    private StudentFamilyMapper studentFamilyMapper;

    /**
     * 查询家庭信息
     * 
     * @param familyId 家庭信息主键
     * @return 家庭信息
     */
    @Override
    public StudentFamily selectStudentFamilyByFamilyId(Long familyId)
    {
        return studentFamilyMapper.selectStudentFamilyByFamilyId(familyId);
    }

    /**
     * 查询家庭信息列表
     * 
     * @param studentFamily 家庭信息
     * @return 家庭信息
     */
    @Override
    public List<StudentFamily> selectStudentFamilyList(StudentFamily studentFamily)
    {
        return studentFamilyMapper.selectStudentFamilyList(studentFamily);
    }

    /**
     * 新增家庭信息
     * 
     * @param studentFamily 家庭信息
     * @return 结果
     */
    @Override
    public int insertStudentFamily(StudentFamily studentFamily)
    {
        return studentFamilyMapper.insertStudentFamily(studentFamily);
    }

    /**
     * 修改家庭信息
     * 
     * @param studentFamily 家庭信息
     * @return 结果
     */
    @Override
    public int updateStudentFamily(StudentFamily studentFamily)
    {
        return studentFamilyMapper.updateStudentFamily(studentFamily);
    }

    /**
     * 批量删除家庭信息
     * 
     * @param familyIds 需要删除的家庭信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentFamilyByFamilyIds(String familyIds)
    {
        return studentFamilyMapper.deleteStudentFamilyByFamilyIds(Convert.toStrArray(familyIds));
    }

    /**
     * 删除家庭信息信息
     * 
     * @param familyId 家庭信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentFamilyByFamilyId(Long familyId)
    {
        return studentFamilyMapper.deleteStudentFamilyByFamilyId(familyId);
    }
}
