package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ClassManagement;

/**
 * 班级管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IClassManagementService 
{
    /**
     * 查询班级管理
     * 
     * @param classId 班级管理主键
     * @return 班级管理
     */
    public ClassManagement selectClassManagementByClassId(Long classId);

    /**
     * 查询班级管理列表
     * 
     * @param classManagement 班级管理
     * @return 班级管理集合
     */
    public List<ClassManagement> selectClassManagementList(ClassManagement classManagement);

    /**
     * 新增班级管理
     * 
     * @param classManagement 班级管理
     * @return 结果
     */
    public int insertClassManagement(ClassManagement classManagement);

    /**
     * 修改班级管理
     * 
     * @param classManagement 班级管理
     * @return 结果
     */
    public int updateClassManagement(ClassManagement classManagement);

    /**
     * 批量删除班级管理
     * 
     * @param classIds 需要删除的班级管理主键集合
     * @return 结果
     */
    public int deleteClassManagementByClassIds(String classIds);

    /**
     * 删除班级管理信息
     * 
     * @param classId 班级管理主键
     * @return 结果
     */
    public int deleteClassManagementByClassId(Long classId);
}
