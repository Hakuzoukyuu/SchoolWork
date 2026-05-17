package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.StudentPaymentMapper;
import com.ruoyi.system.domain.StudentPayment;
import com.ruoyi.system.service.IStudentPaymentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生缴费Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class StudentPaymentServiceImpl implements IStudentPaymentService 
{
    @Autowired
    private StudentPaymentMapper studentPaymentMapper;

    /**
     * 查询学生缴费
     * 
     * @param studentId 学生缴费主键
     * @return 学生缴费
     */
    @Override
    public StudentPayment selectStudentPaymentByStudentId(String studentId)
    {
        return studentPaymentMapper.selectStudentPaymentByStudentId(studentId);
    }

    /**
     * 查询学生缴费列表
     * 
     * @param studentPayment 学生缴费
     * @return 学生缴费
     */
    @Override
    public List<StudentPayment> selectStudentPaymentList(StudentPayment studentPayment)
    {
        return studentPaymentMapper.selectStudentPaymentList(studentPayment);
    }

    /**
     * 新增学生缴费
     * 
     * @param studentPayment 学生缴费
     * @return 结果
     */
    @Override
    public int insertStudentPayment(StudentPayment studentPayment)
    {
        studentPayment.setCreateTime(DateUtils.getNowDate());
        return studentPaymentMapper.insertStudentPayment(studentPayment);
    }

    /**
     * 修改学生缴费
     * 
     * @param studentPayment 学生缴费
     * @return 结果
     */
    @Override
    public int updateStudentPayment(StudentPayment studentPayment)
    {
        studentPayment.setUpdateTime(DateUtils.getNowDate());
        return studentPaymentMapper.updateStudentPayment(studentPayment);
    }

    /**
     * 批量删除学生缴费
     * 
     * @param studentIds 需要删除的学生缴费主键
     * @return 结果
     */
    @Override
    public int deleteStudentPaymentByStudentIds(String studentIds)
    {
        return studentPaymentMapper.deleteStudentPaymentByStudentIds(Convert.toStrArray(studentIds));
    }

    /**
     * 删除学生缴费信息
     * 
     * @param studentId 学生缴费主键
     * @return 结果
     */
    @Override
    public int deleteStudentPaymentByStudentId(String studentId)
    {
        return studentPaymentMapper.deleteStudentPaymentByStudentId(studentId);
    }
}
