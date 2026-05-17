package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.StudentMental;

/**
 * 学生心理健康Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface StudentMentalMapper 
{
    /**
     * 查询学生心理健康
     * 
     * @param id 学生心理健康主键
     * @return 学生心理健康
     */
    public StudentMental selectStudentMentalById(Long id);

    /**
     * 查询学生心理健康列表
     * 
     * @param studentMental 学生心理健康
     * @return 学生心理健康集合
     */
    public List<StudentMental> selectStudentMentalList(StudentMental studentMental);

    /**
     * 新增学生心理健康
     * 
     * @param studentMental 学生心理健康
     * @return 结果
     */
    public int insertStudentMental(StudentMental studentMental);

    /**
     * 修改学生心理健康
     * 
     * @param studentMental 学生心理健康
     * @return 结果
     */
    public int updateStudentMental(StudentMental studentMental);

    /**
     * 删除学生心理健康
     * 
     * @param id 学生心理健康主键
     * @return 结果
     */
    public int deleteStudentMentalById(Long id);

    /**
     * 批量删除学生心理健康
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentMentalByIds(String[] ids);
}
