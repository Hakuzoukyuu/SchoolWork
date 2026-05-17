package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AssetManagement;

/**
 * 资产管理Service接口
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public interface IAssetManagementService 
{
    /**
     * 查询资产管理
     * 
     * @param id 资产管理主键
     * @return 资产管理
     */
    public AssetManagement selectAssetManagementById(Long id);

    /**
     * 查询资产管理列表
     * 
     * @param assetManagement 资产管理
     * @return 资产管理集合
     */
    public List<AssetManagement> selectAssetManagementList(AssetManagement assetManagement);

    /**
     * 新增资产管理
     * 
     * @param assetManagement 资产管理
     * @return 结果
     */
    public int insertAssetManagement(AssetManagement assetManagement);

    /**
     * 修改资产管理
     * 
     * @param assetManagement 资产管理
     * @return 结果
     */
    public int updateAssetManagement(AssetManagement assetManagement);

    /**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的资产管理主键集合
     * @return 结果
     */
    public int deleteAssetManagementByIds(String ids);

    /**
     * 删除资产管理信息
     * 
     * @param id 资产管理主键
     * @return 结果
     */
    public int deleteAssetManagementById(Long id);
}
