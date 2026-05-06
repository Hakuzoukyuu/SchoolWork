package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CompanyCoop;
import com.ruoyi.system.domain.StudentInternship;

/**
 * 校企合作(父)Mapper接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface CompanyCoopMapper 
{
    /**
     * 查询校企合作(父)
     * 
     * @param companyId 校企合作(父)主键
     * @return 校企合作(父)
     */
    public CompanyCoop selectCompanyCoopByCompanyId(String companyId);

    /**
     * 查询校企合作(父)列表
     * 
     * @param companyCoop 校企合作(父)
     * @return 校企合作(父)集合
     */
    public List<CompanyCoop> selectCompanyCoopList(CompanyCoop companyCoop);

    /**
     * 新增校企合作(父)
     * 
     * @param companyCoop 校企合作(父)
     * @return 结果
     */
    public int insertCompanyCoop(CompanyCoop companyCoop);

    /**
     * 修改校企合作(父)
     * 
     * @param companyCoop 校企合作(父)
     * @return 结果
     */
    public int updateCompanyCoop(CompanyCoop companyCoop);

    /**
     * 删除校企合作(父)
     * 
     * @param companyId 校企合作(父)主键
     * @return 结果
     */
    public int deleteCompanyCoopByCompanyId(String companyId);

    /**
     * 批量删除校企合作(父)
     * 
     * @param companyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyCoopByCompanyIds(String[] companyIds);

    /**
     * 批量删除企业实习(子)
     * 
     * @param companyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentInternshipByCompanyIds(String[] companyIds);
    
    /**
     * 批量新增企业实习(子)
     * 
     * @param studentInternshipList 企业实习(子)列表
     * @return 结果
     */
    public int batchStudentInternship(List<StudentInternship> studentInternshipList);
    

    /**
     * 通过校企合作(父)主键删除企业实习(子)信息
     * 
     * @param companyId 校企合作(父)ID
     * @return 结果
     */
    public int deleteStudentInternshipByCompanyId(String companyId);
}
