package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.StudentPayment;

/**
 * 学生缴费Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IStudentPaymentService 
{
    /**
     * 查询学生缴费
     * 
     * @param studentId 学生缴费主键
     * @return 学生缴费
     */
    public StudentPayment selectStudentPaymentByStudentId(String studentId);

    /**
     * 查询学生缴费列表
     * 
     * @param studentPayment 学生缴费
     * @return 学生缴费集合
     */
    public List<StudentPayment> selectStudentPaymentList(StudentPayment studentPayment);

    /**
     * 新增学生缴费
     * 
     * @param studentPayment 学生缴费
     * @return 结果
     */
    public int insertStudentPayment(StudentPayment studentPayment);

    /**
     * 修改学生缴费
     * 
     * @param studentPayment 学生缴费
     * @return 结果
     */
    public int updateStudentPayment(StudentPayment studentPayment);

    /**
     * 批量删除学生缴费
     * 
     * @param studentIds 需要删除的学生缴费主键集合
     * @return 结果
     */
    public int deleteStudentPaymentByStudentIds(String studentIds);

    /**
     * 删除学生缴费信息
     * 
     * @param studentId 学生缴费主键
     * @return 结果
     */
    public int deleteStudentPaymentByStudentId(String studentId);
}
