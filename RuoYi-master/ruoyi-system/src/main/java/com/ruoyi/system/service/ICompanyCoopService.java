package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CompanyCoop;

/**
 * 校企合作(父)Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface ICompanyCoopService 
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
     * 批量删除校企合作(父)
     * 
     * @param companyIds 需要删除的校企合作(父)主键集合
     * @return 结果
     */
    public int deleteCompanyCoopByCompanyIds(String companyIds);

    /**
     * 删除校企合作(父)信息
     * 
     * @param companyId 校企合作(父)主键
     * @return 结果
     */
    public int deleteCompanyCoopByCompanyId(String companyId);
}
