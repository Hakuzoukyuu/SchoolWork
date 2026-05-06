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
import com.ruoyi.system.domain.CanteenStall;
import com.ruoyi.system.service.ICanteenStallService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 食堂档口主Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/stall")
public class CanteenStallController extends BaseController
{
    private String prefix = "system/stall";

    @Autowired
    private ICanteenStallService canteenStallService;

    @RequiresPermissions("system:stall:view")
    @GetMapping()
    public String stall()
    {
        return prefix + "/stall";
    }

    /**
     * 查询食堂档口主列表
     */
    @RequiresPermissions("system:stall:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CanteenStall canteenStall)
    {
        startPage();
        List<CanteenStall> list = canteenStallService.selectCanteenStallList(canteenStall);
        return getDataTable(list);
    }

    /**
     * 导出食堂档口主列表
     */
    @RequiresPermissions("system:stall:export")
    @Log(title = "食堂档口主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CanteenStall canteenStall)
    {
        List<CanteenStall> list = canteenStallService.selectCanteenStallList(canteenStall);
        ExcelUtil<CanteenStall> util = new ExcelUtil<CanteenStall>(CanteenStall.class);
        return util.exportExcel(list, "食堂档口主数据");
    }

    /**
     * 新增食堂档口主
     */
    @RequiresPermissions("system:stall:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存食堂档口主
     */
    @RequiresPermissions("system:stall:add")
    @Log(title = "食堂档口主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CanteenStall canteenStall)
    {
        return toAjax(canteenStallService.insertCanteenStall(canteenStall));
    }

    /**
     * 修改食堂档口主
     */
    @RequiresPermissions("system:stall:edit")
    @GetMapping("/edit/{stallId}")
    public String edit(@PathVariable("stallId") Long stallId, ModelMap mmap)
    {
        CanteenStall canteenStall = canteenStallService.selectCanteenStallByStallId(stallId);
        mmap.put("canteenStall", canteenStall);
        return prefix + "/edit";
    }

    /**
     * 修改保存食堂档口主
     */
    @RequiresPermissions("system:stall:edit")
    @Log(title = "食堂档口主", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CanteenStall canteenStall)
    {
        return toAjax(canteenStallService.updateCanteenStall(canteenStall));
    }

    /**
     * 删除食堂档口主
     */
    @RequiresPermissions("system:stall:remove")
    @Log(title = "食堂档口主", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(canteenStallService.deleteCanteenStallByStallIds(ids));
    }
}
