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
import com.ruoyi.system.domain.StaffAttendance;
import com.ruoyi.system.service.IStaffAttendanceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/attendance")
public class StaffAttendanceController extends BaseController
{
    private String prefix = "system/attendance";

    @Autowired
    private IStaffAttendanceService staffAttendanceService;

    @RequiresPermissions("system:attendance:view")
    @GetMapping()
    public String attendance()
    {
        return prefix + "/attendance";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:attendance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StaffAttendance staffAttendance)
    {
        startPage();
        List<StaffAttendance> list = staffAttendanceService.selectStaffAttendanceList(staffAttendance);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:attendance:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StaffAttendance staffAttendance)
    {
        List<StaffAttendance> list = staffAttendanceService.selectStaffAttendanceList(staffAttendance);
        ExcelUtil<StaffAttendance> util = new ExcelUtil<StaffAttendance>(StaffAttendance.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @RequiresPermissions("system:attendance:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:attendance:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StaffAttendance staffAttendance)
    {
        return toAjax(staffAttendanceService.insertStaffAttendance(staffAttendance));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:attendance:edit")
    @GetMapping("/edit/{attenId}")
    public String edit(@PathVariable("attenId") Long attenId, ModelMap mmap)
    {
        StaffAttendance staffAttendance = staffAttendanceService.selectStaffAttendanceByAttenId(attenId);
        mmap.put("staffAttendance", staffAttendance);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:attendance:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StaffAttendance staffAttendance)
    {
        return toAjax(staffAttendanceService.updateStaffAttendance(staffAttendance));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:attendance:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(staffAttendanceService.deleteStaffAttendanceByAttenIds(ids));
    }
}
