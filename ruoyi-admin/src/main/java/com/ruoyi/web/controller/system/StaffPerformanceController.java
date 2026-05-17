package com.ruoyi.web.controller.system;

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
import com.ruoyi.system.domain.StaffPerformance;
import com.ruoyi.system.service.IStaffPerformanceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 绩效考核管理Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/performance")
public class StaffPerformanceController extends BaseController
{
    private String prefix = "system/performance";

    @Autowired
    private IStaffPerformanceService staffPerformanceService;

    @RequiresPermissions("system:performance:view")
    @GetMapping()
    public String performance()
    {
        return prefix + "/performance";
    }

    /**
     * 查询绩效考核管理列表
     */
    @RequiresPermissions("system:performance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StaffPerformance staffPerformance)
    {
        startPage();
        List<StaffPerformance> list = staffPerformanceService.selectStaffPerformanceList(staffPerformance);
        return getDataTable(list);
    }

    /**
     * 导出绩效考核管理列表
     */
    @RequiresPermissions("system:performance:export")
    @Log(title = "绩效考核管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StaffPerformance staffPerformance)
    {
        List<StaffPerformance> list = staffPerformanceService.selectStaffPerformanceList(staffPerformance);
        ExcelUtil<StaffPerformance> util = new ExcelUtil<StaffPerformance>(StaffPerformance.class);
        return util.exportExcel(list, "绩效考核管理数据");
    }

    /**
     * 新增绩效考核管理
     */
    @RequiresPermissions("system:performance:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存绩效考核管理
     */
    @RequiresPermissions("system:performance:add")
    @Log(title = "绩效考核管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StaffPerformance staffPerformance)
    {
        return toAjax(staffPerformanceService.insertStaffPerformance(staffPerformance));
    }

    /**
     * 修改绩效考核管理
     */
    @RequiresPermissions("system:performance:edit")
    @GetMapping("/edit/{perfId}")
    public String edit(@PathVariable("perfId") Long perfId, ModelMap mmap)
    {
        StaffPerformance staffPerformance = staffPerformanceService.selectStaffPerformanceByPerfId(perfId);
        mmap.put("staffPerformance", staffPerformance);
        return prefix + "/edit";
    }

    /**
     * 修改保存绩效考核管理
     */
    @RequiresPermissions("system:performance:edit")
    @Log(title = "绩效考核管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StaffPerformance staffPerformance)
    {
        return toAjax(staffPerformanceService.updateStaffPerformance(staffPerformance));
    }

    /**
     * 删除绩效考核管理
     */
    @RequiresPermissions("system:performance:remove")
    @Log(title = "绩效考核管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(staffPerformanceService.deleteStaffPerformanceByPerfIds(ids));
    }
}
