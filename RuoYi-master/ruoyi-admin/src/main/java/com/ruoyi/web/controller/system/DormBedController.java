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
import com.ruoyi.system.domain.DormBed;
import com.ruoyi.system.service.IDormBedService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 床位与学生入住子Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/bed")
public class DormBedController extends BaseController
{
    private String prefix = "system/bed";

    @Autowired
    private IDormBedService dormBedService;

    @RequiresPermissions("system:bed:view")
    @GetMapping()
    public String bed()
    {
        return prefix + "/bed";
    }

    /**
     * 查询床位与学生入住子列表
     */
    @RequiresPermissions("system:bed:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DormBed dormBed)
    {
        startPage();
        List<DormBed> list = dormBedService.selectDormBedList(dormBed);
        return getDataTable(list);
    }

    /**
     * 导出床位与学生入住子列表
     */
    @RequiresPermissions("system:bed:export")
    @Log(title = "床位与学生入住子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DormBed dormBed)
    {
        List<DormBed> list = dormBedService.selectDormBedList(dormBed);
        ExcelUtil<DormBed> util = new ExcelUtil<DormBed>(DormBed.class);
        return util.exportExcel(list, "床位与学生入住子数据");
    }

    /**
     * 新增床位与学生入住子
     */
    @RequiresPermissions("system:bed:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存床位与学生入住子
     */
    @RequiresPermissions("system:bed:add")
    @Log(title = "床位与学生入住子", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DormBed dormBed)
    {
        return toAjax(dormBedService.insertDormBed(dormBed));
    }

    /**
     * 修改床位与学生入住子
     */
    @RequiresPermissions("system:bed:edit")
    @GetMapping("/edit/{bedId}")
    public String edit(@PathVariable("bedId") Long bedId, ModelMap mmap)
    {
        DormBed dormBed = dormBedService.selectDormBedByBedId(bedId);
        mmap.put("dormBed", dormBed);
        return prefix + "/edit";
    }

    /**
     * 修改保存床位与学生入住子
     */
    @RequiresPermissions("system:bed:edit")
    @Log(title = "床位与学生入住子", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DormBed dormBed)
    {
        return toAjax(dormBedService.updateDormBed(dormBed));
    }

    /**
     * 删除床位与学生入住子
     */
    @RequiresPermissions("system:bed:remove")
    @Log(title = "床位与学生入住子", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dormBedService.deleteDormBedByBedIds(ids));
    }
}
