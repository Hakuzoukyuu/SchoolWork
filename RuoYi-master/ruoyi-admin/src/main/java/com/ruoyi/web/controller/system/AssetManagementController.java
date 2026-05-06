package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AssetManagement;
import com.ruoyi.system.service.IAssetManagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资产管理Controller
 *
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
// 1. 修正请求路径：匹配你的菜单访问地址
@RequestMapping("/system/financialmanagement")
public class AssetManagementController extends BaseController
{
    // 2. 修正页面前缀：精准匹配你的页面文件夹路径
    private String prefix = "system/financialmanagement";

    @Autowired
    private IAssetManagementService assetManagementService;

    // 3. 修正权限标识（唯一不冲突）
    @RequiresPermissions("system:financialmanagement:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 查询资产管理列表
     */
    @RequiresPermissions("system:financialmanagement:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetManagement assetManagement)
    {
        startPage();
        List<AssetManagement> list = assetManagementService.selectAssetManagementList(assetManagement);
        return getDataTable(list);
    }

    /**
     * 导出资产管理列表
     */
    @RequiresPermissions("system:financialmanagement:export")
    @Log(title = "资产管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetManagement assetManagement)
    {
        List<AssetManagement> list = assetManagementService.selectAssetManagementList(assetManagement);
        ExcelUtil<AssetManagement> util = new ExcelUtil<AssetManagement>(AssetManagement.class);
        return util.exportExcel(list, "资产管理数据");
    }

    /**
     * 新增资产管理
     */
    @RequiresPermissions("system:financialmanagement:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资产管理
     */
    @RequiresPermissions("system:financialmanagement:add")
    @Log(title = "资产管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetManagement assetManagement)
    {
        return toAjax(assetManagementService.insertAssetManagement(assetManagement));
    }

    /**
     * 修改资产管理
     */
    @RequiresPermissions("system:financialmanagement:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetManagement assetManagement = assetManagementService.selectAssetManagementById(id);
        mmap.put("assetManagement", assetManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存资产管理
     */
    @RequiresPermissions("system:financialmanagement:edit")
    @Log(title = "资产管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetManagement assetManagement)
    {
        return toAjax(assetManagementService.updateAssetManagement(assetManagement));
    }

    /**
     * 删除资产管理
     */
    @RequiresPermissions("system:financialmanagement:remove")
    @Log(title = "资产管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetManagementService.deleteAssetManagementByIds(ids));
    }
}