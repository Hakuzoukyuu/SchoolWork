package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentMentalMapper;
import com.ruoyi.system.domain.StudentMental;
import com.ruoyi.system.service.IStudentMentalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生心理健康Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class StudentMentalServiceImpl implements IStudentMentalService 
{
    @Autowired
    private StudentMentalMapper studentMentalMapper;

    /**
     * 查询学生心理健康
     * 
     * @param id 学生心理健康主键
     * @return 学生心理健康
     */
    @Override
    public StudentMental selectStudentMentalById(Long id)
    {
        return studentMentalMapper.selectStudentMentalById(id);
    }

    /**
     * 查询学生心理健康列表
     * 
     * @param studentMental 学生心理健康
     * @return 学生心理健康
     */
    @Override
    public List<StudentMental> selectStudentMentalList(StudentMental studentMental)
    {
        return studentMentalMapper.selectStudentMentalList(studentMental);
    }

    /**
     * 新增学生心理健康
     * 
     * @param studentMental 学生心理健康
     * @return 结果
     */
    @Override
    public int insertStudentMental(StudentMental studentMental)
    {
        studentMental.setCreateTime(DateUtils.getNowDate());
        return studentMentalMapper.insertStudentMental(studentMental);
    }

    /**
     * 修改学生心理健康
     * 
     * @param studentMental 学生心理健康
     * @return 结果
     */
    @Override
    public int updateStudentMental(StudentMental studentMental)
    {
        studentMental.setUpdateTime(DateUtils.getNowDate());
        return studentMentalMapper.updateStudentMental(studentMental);
    }

    /**
     * 批量删除学生心理健康
     * 
     * @param ids 需要删除的学生心理健康主键
     * @return 结果
     */
    @Override
    public int deleteStudentMentalByIds(String ids)
    {
        return studentMentalMapper.deleteStudentMentalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生心理健康信息
     * 
     * @param id 学生心理健康主键
     * @return 结果
     */
    @Override
    public int deleteStudentMentalById(Long id)
    {
        return studentMentalMapper.deleteStudentMentalById(id);
    }
}
