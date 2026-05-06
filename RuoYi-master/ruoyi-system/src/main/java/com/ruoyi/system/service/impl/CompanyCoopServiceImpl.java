package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.StudentInternship;
import com.ruoyi.system.mapper.CompanyCoopMapper;
import com.ruoyi.system.domain.CompanyCoop;
import com.ruoyi.system.service.ICompanyCoopService;
import com.ruoyi.common.core.text.Convert;

/**
 * 校企合作(父)Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class CompanyCoopServiceImpl implements ICompanyCoopService 
{
    @Autowired
    private CompanyCoopMapper companyCoopMapper;

    /**
     * 查询校企合作(父)
     * 
     * @param companyId 校企合作(父)主键
     * @return 校企合作(父)
     */
    @Override
    public CompanyCoop selectCompanyCoopByCompanyId(String companyId)
    {
        return companyCoopMapper.selectCompanyCoopByCompanyId(companyId);
    }

    /**
     * 查询校企合作(父)列表
     * 
     * @param companyCoop 校企合作(父)
     * @return 校企合作(父)
     */
    @Override
    public List<CompanyCoop> selectCompanyCoopList(CompanyCoop companyCoop)
    {
        return companyCoopMapper.selectCompanyCoopList(companyCoop);
    }

    /**
     * 新增校企合作(父)
     * 
     * @param companyCoop 校企合作(父)
     * @return 结果
     */
    @Transactional
    @Override
    public int insertCompanyCoop(CompanyCoop companyCoop)
    {
        companyCoop.setCreateTime(DateUtils.getNowDate());
        int rows = companyCoopMapper.insertCompanyCoop(companyCoop);
        insertStudentInternship(companyCoop);
        return rows;
    }

    /**
     * 修改校企合作(父)
     * 
     * @param companyCoop 校企合作(父)
     * @return 结果
     */
    @Transactional
    @Override
    public int updateCompanyCoop(CompanyCoop companyCoop)
    {
        companyCoop.setUpdateTime(DateUtils.getNowDate());
        companyCoopMapper.deleteStudentInternshipByCompanyId(companyCoop.getCompanyId());
        insertStudentInternship(companyCoop);
        return companyCoopMapper.updateCompanyCoop(companyCoop);
    }

    /**
     * 批量删除校企合作(父)
     * 
     * @param companyIds 需要删除的校企合作(父)主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCompanyCoopByCompanyIds(String companyIds)
    {
        companyCoopMapper.deleteStudentInternshipByCompanyIds(Convert.toStrArray(companyIds));
        return companyCoopMapper.deleteCompanyCoopByCompanyIds(Convert.toStrArray(companyIds));
    }

    /**
     * 删除校企合作(父)信息
     * 
     * @param companyId 校企合作(父)主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteCompanyCoopByCompanyId(String companyId)
    {
        companyCoopMapper.deleteStudentInternshipByCompanyId(companyId);
        return companyCoopMapper.deleteCompanyCoopByCompanyId(companyId);
    }

    /**
     * 新增企业实习(子)信息
     * 
     * @param companyCoop 校企合作(父)对象
     */
    public void insertStudentInternship(CompanyCoop companyCoop)
    {
        List<StudentInternship> studentInternshipList = companyCoop.getStudentInternshipList();
        String companyId = companyCoop.getCompanyId();
        if (StringUtils.isNotNull(studentInternshipList))
        {
            List<StudentInternship> list = new ArrayList<StudentInternship>();
            for (StudentInternship studentInternship : studentInternshipList)
            {
                studentInternship.setCompanyId(companyId);
                list.add(studentInternship);
            }
            if (list.size() > 0)
            {
                companyCoopMapper.batchStudentInternship(list);
            }
        }
    }
}
