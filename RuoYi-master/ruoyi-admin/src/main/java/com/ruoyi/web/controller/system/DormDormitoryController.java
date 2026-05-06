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
import com.ruoyi.system.domain.DormDormitory;
import com.ruoyi.system.service.IDormDormitoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍信息主Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/dormitory")
public class DormDormitoryController extends BaseController
{
    private String prefix = "system/dormitory";

    @Autowired
    private IDormDormitoryService dormDormitoryService;

    @RequiresPermissions("system:dormitory:view")
    @GetMapping()
    public String dormitory()
    {
        return prefix + "/dormitory";
    }

    /**
     * 查询宿舍信息主列表
     */
    @RequiresPermissions("system:dormitory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DormDormitory dormDormitory)
    {
        startPage();
        List<DormDormitory> list = dormDormitoryService.selectDormDormitoryList(dormDormitory);
        return getDataTable(list);
    }

    /**
     * 导出宿舍信息主列表
     */
    @RequiresPermissions("system:dormitory:export")
    @Log(title = "宿舍信息主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DormDormitory dormDormitory)
    {
        List<DormDormitory> list = dormDormitoryService.selectDormDormitoryList(dormDormitory);
        ExcelUtil<DormDormitory> util = new ExcelUtil<DormDormitory>(DormDormitory.class);
        return util.exportExcel(list, "宿舍信息主数据");
    }

    /**
     * 新增宿舍信息主
     */
    @RequiresPermissions("system:dormitory:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存宿舍信息主
     */
    @RequiresPermissions("system:dormitory:add")
    @Log(title = "宿舍信息主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DormDormitory dormDormitory)
    {
        return toAjax(dormDormitoryService.insertDormDormitory(dormDormitory));
    }

    /**
     * 修改宿舍信息主
     */
    @RequiresPermissions("system:dormitory:edit")
    @GetMapping("/edit/{dormId}")
    public String edit(@PathVariable("dormId") Long dormId, ModelMap mmap)
    {
        DormDormitory dormDormitory = dormDormitoryService.selectDormDormitoryByDormId(dormId);
        mmap.put("dormDormitory", dormDormitory);
        return prefix + "/edit";
    }

    /**
     * 修改保存宿舍信息主
     */
    @RequiresPermissions("system:dormitory:edit")
    @Log(title = "宿舍信息主", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DormDormitory dormDormitory)
    {
        return toAjax(dormDormitoryService.updateDormDormitory(dormDormitory));
    }

    /**
     * 删除宿舍信息主
     */
    @RequiresPermissions("system:dormitory:remove")
    @Log(title = "宿舍信息主", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dormDormitoryService.deleteDormDormitoryByDormIds(ids));
    }
}
