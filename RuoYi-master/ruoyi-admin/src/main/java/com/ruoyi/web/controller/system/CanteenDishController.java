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
import com.ruoyi.system.domain.CanteenDish;
import com.ruoyi.system.service.ICanteenDishService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 菜品台账子Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/dish")
public class CanteenDishController extends BaseController
{
    private String prefix = "system/dish";

    @Autowired
    private ICanteenDishService canteenDishService;

    @RequiresPermissions("system:dish:view")
    @GetMapping()
    public String dish()
    {
        return prefix + "/dish";
    }

    /**
     * 查询菜品台账子列表
     */
    @RequiresPermissions("system:dish:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CanteenDish canteenDish)
    {
        startPage();
        List<CanteenDish> list = canteenDishService.selectCanteenDishList(canteenDish);
        return getDataTable(list);
    }

    /**
     * 导出菜品台账子列表
     */
    @RequiresPermissions("system:dish:export")
    @Log(title = "菜品台账子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CanteenDish canteenDish)
    {
        List<CanteenDish> list = canteenDishService.selectCanteenDishList(canteenDish);
        ExcelUtil<CanteenDish> util = new ExcelUtil<CanteenDish>(CanteenDish.class);
        return util.exportExcel(list, "菜品台账子数据");
    }

    /**
     * 新增菜品台账子
     */
    @RequiresPermissions("system:dish:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存菜品台账子
     */
    @RequiresPermissions("system:dish:add")
    @Log(title = "菜品台账子", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CanteenDish canteenDish)
    {
        return toAjax(canteenDishService.insertCanteenDish(canteenDish));
    }

    /**
     * 修改菜品台账子
     */
    @RequiresPermissions("system:dish:edit")
    @GetMapping("/edit/{dishId}")
    public String edit(@PathVariable("dishId") Long dishId, ModelMap mmap)
    {
        CanteenDish canteenDish = canteenDishService.selectCanteenDishByDishId(dishId);
        mmap.put("canteenDish", canteenDish);
        return prefix + "/edit";
    }

    /**
     * 修改保存菜品台账子
     */
    @RequiresPermissions("system:dish:edit")
    @Log(title = "菜品台账子", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CanteenDish canteenDish)
    {
        return toAjax(canteenDishService.updateCanteenDish(canteenDish));
    }

    /**
     * 删除菜品台账子
     */
    @RequiresPermissions("system:dish:remove")
    @Log(title = "菜品台账子", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(canteenDishService.deleteCanteenDishByDishIds(ids));
    }
}
