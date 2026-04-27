package com.ruoyi.Canteenmanagement.controller;

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
import com.ruoyi.Canteenmanagement.domain.CanteenShop;
import com.ruoyi.Canteenmanagement.service.ICanteenShopService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 食堂店铺管理Controller
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
@Controller
@RequestMapping("/CanteenManagement/CanteenInfo")
public class CanteenShopController extends BaseController
{
    private String prefix = "CanteenManagement/CanteenInfo";

    @Autowired
    private ICanteenShopService canteenShopService;

    @RequiresPermissions("CanteenManagement:CanteenInfo:view")
    @GetMapping()
    public String CanteenInfo()
    {
        return prefix + "/CanteenInfo";
    }

    /**
     * 查询食堂店铺管理列表
     */
    @RequiresPermissions("CanteenManagement:CanteenInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CanteenShop canteenShop)
    {
        startPage();
        List<CanteenShop> list = canteenShopService.selectCanteenShopList(canteenShop);
        return getDataTable(list);
    }

    /**
     * 导出食堂店铺管理列表
     */
    @RequiresPermissions("CanteenManagement:CanteenInfo:export")
    @Log(title = "食堂店铺管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CanteenShop canteenShop)
    {
        List<CanteenShop> list = canteenShopService.selectCanteenShopList(canteenShop);
        ExcelUtil<CanteenShop> util = new ExcelUtil<CanteenShop>(CanteenShop.class);
        return util.exportExcel(list, "食堂店铺管理数据");
    }

    /**
     * 新增食堂店铺管理
     */
    @RequiresPermissions("CanteenManagement:CanteenInfo:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存食堂店铺管理
     */
    @RequiresPermissions("CanteenManagement:CanteenInfo:add")
    @Log(title = "食堂店铺管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CanteenShop canteenShop)
    {
        return toAjax(canteenShopService.insertCanteenShop(canteenShop));
    }

    /**
     * 修改食堂店铺管理
     */
    @RequiresPermissions("CanteenManagement:CanteenInfo:edit")
    @GetMapping("/edit/{shopId}")
    public String edit(@PathVariable("shopId") Long shopId, ModelMap mmap)
    {
        CanteenShop canteenShop = canteenShopService.selectCanteenShopByShopId(shopId);
        mmap.put("canteenShop", canteenShop);
        return prefix + "/edit";
    }

    /**
     * 修改保存食堂店铺管理
     */
    @RequiresPermissions("CanteenManagement:CanteenInfo:edit")
    @Log(title = "食堂店铺管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CanteenShop canteenShop)
    {
        return toAjax(canteenShopService.updateCanteenShop(canteenShop));
    }

    /**
     * 删除食堂店铺管理
     */
    @RequiresPermissions("CanteenManagement:CanteenInfo:remove")
    @Log(title = "食堂店铺管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(canteenShopService.deleteCanteenShopByShopIds(ids));
    }
}
