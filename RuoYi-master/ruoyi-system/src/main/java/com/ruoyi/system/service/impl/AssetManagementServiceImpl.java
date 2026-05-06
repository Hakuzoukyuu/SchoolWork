package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetManagementMapper;
import com.ruoyi.system.domain.AssetManagement;
import com.ruoyi.system.service.IAssetManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 资产管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Service
public class AssetManagementServiceImpl implements IAssetManagementService 
{
    @Autowired
    private AssetManagementMapper assetManagementMapper;

    /**
     * 查询资产管理
     * 
     * @param id 资产管理主键
     * @return 资产管理
     */
    @Override
    public AssetManagement selectAssetManagementById(Long id)
    {
        return assetManagementMapper.selectAssetManagementById(id);
    }

    /**
     * 查询资产管理列表
     * 
     * @param assetManagement 资产管理
     * @return 资产管理
     */
    @Override
    public List<AssetManagement> selectAssetManagementList(AssetManagement assetManagement)
    {
        return assetManagementMapper.selectAssetManagementList(assetManagement);
    }

    /**
     * 新增资产管理
     * 
     * @param assetManagement 资产管理
     * @return 结果
     */
    @Override
    public int insertAssetManagement(AssetManagement assetManagement)
    {
        assetManagement.setCreateTime(DateUtils.getNowDate());
        return assetManagementMapper.insertAssetManagement(assetManagement);
    }

    /**
     * 修改资产管理
     * 
     * @param assetManagement 资产管理
     * @return 结果
     */
    @Override
    public int updateAssetManagement(AssetManagement assetManagement)
    {
        assetManagement.setUpdateTime(DateUtils.getNowDate());
        return assetManagementMapper.updateAssetManagement(assetManagement);
    }

    /**
     * 批量删除资产管理
     * 
     * @param ids 需要删除的资产管理主键
     * @return 结果
     */
    @Override
    public int deleteAssetManagementByIds(String ids)
    {
        return assetManagementMapper.deleteAssetManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资产管理信息
     * 
     * @param id 资产管理主键
     * @return 结果
     */
    @Override
    public int deleteAssetManagementById(Long id)
    {
        return assetManagementMapper.deleteAssetManagementById(id);
    }
}
