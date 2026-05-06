package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassManagementMapper;
import com.ruoyi.system.domain.ClassManagement;
import com.ruoyi.system.service.IClassManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 班级管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class ClassManagementServiceImpl implements IClassManagementService 
{
    @Autowired
    private ClassManagementMapper classManagementMapper;

    /**
     * 查询班级管理
     * 
     * @param classId 班级管理主键
     * @return 班级管理
     */
    @Override
    public ClassManagement selectClassManagementByClassId(Long classId)
    {
        return classManagementMapper.selectClassManagementByClassId(classId);
    }

    /**
     * 查询班级管理列表
     * 
     * @param classManagement 班级管理
     * @return 班级管理
     */
    @Override
    public List<ClassManagement> selectClassManagementList(ClassManagement classManagement)
    {
        return classManagementMapper.selectClassManagementList(classManagement);
    }

    /**
     * 新增班级管理
     * 
     * @param classManagement 班级管理
     * @return 结果
     */
    @Override
    public int insertClassManagement(ClassManagement classManagement)
    {
        classManagement.setCreateTime(DateUtils.getNowDate());
        return classManagementMapper.insertClassManagement(classManagement);
    }

    /**
     * 修改班级管理
     * 
     * @param classManagement 班级管理
     * @return 结果
     */
    @Override
    public int updateClassManagement(ClassManagement classManagement)
    {
        classManagement.setUpdateTime(DateUtils.getNowDate());
        return classManagementMapper.updateClassManagement(classManagement);
    }

    /**
     * 批量删除班级管理
     * 
     * @param classIds 需要删除的班级管理主键
     * @return 结果
     */
    @Override
    public int deleteClassManagementByClassIds(String classIds)
    {
        return classManagementMapper.deleteClassManagementByClassIds(Convert.toStrArray(classIds));
    }

    /**
     * 删除班级管理信息
     * 
     * @param classId 班级管理主键
     * @return 结果
     */
    @Override
    public int deleteClassManagementByClassId(Long classId)
    {
        return classManagementMapper.deleteClassManagementByClassId(classId);
    }
}
