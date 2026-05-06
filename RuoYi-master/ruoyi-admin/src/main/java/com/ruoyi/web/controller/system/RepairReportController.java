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
import com.ruoyi.system.domain.RepairReport;
import com.ruoyi.system.service.IRepairReportService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修报修Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/report")
public class RepairReportController extends BaseController
{
    private String prefix = "system/report";

    @Autowired
    private IRepairReportService repairReportService;

    @RequiresPermissions("system:report:view")
    @GetMapping()
    public String report()
    {
        return prefix + "/report";
    }

    /**
     * 查询维修报修列表
     */
    @RequiresPermissions("system:report:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RepairReport repairReport)
    {
        startPage();
        List<RepairReport> list = repairReportService.selectRepairReportList(repairReport);
        return getDataTable(list);
    }

    /**
     * 导出维修报修列表
     */
    @RequiresPermissions("system:report:export")
    @Log(title = "维修报修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RepairReport repairReport)
    {
        List<RepairReport> list = repairReportService.selectRepairReportList(repairReport);
        ExcelUtil<RepairReport> util = new ExcelUtil<RepairReport>(RepairReport.class);
        return util.exportExcel(list, "维修报修数据");
    }

    /**
     * 新增维修报修
     */
    @RequiresPermissions("system:report:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存维修报修
     */
    @RequiresPermissions("system:report:add")
    @Log(title = "维修报修", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RepairReport repairReport)
    {
        return toAjax(repairReportService.insertRepairReport(repairReport));
    }

    /**
     * 修改维修报修
     */
    @RequiresPermissions("system:report:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RepairReport repairReport = repairReportService.selectRepairReportById(id);
        mmap.put("repairReport", repairReport);
        return prefix + "/edit";
    }

    /**
     * 修改保存维修报修
     */
    @RequiresPermissions("system:report:edit")
    @Log(title = "维修报修", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RepairReport repairReport)
    {
        return toAjax(repairReportService.updateRepairReport(repairReport));
    }

    /**
     * 删除维修报修
     */
    @RequiresPermissions("system:report:remove")
    @Log(title = "维修报修", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(repairReportService.deleteRepairReportByIds(ids));
    }
}
