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
import com.ruoyi.system.domain.StaffInfo;
import com.ruoyi.system.service.IStaffInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教职工基础档案主Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/info")
public class StaffInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IStaffInfoService staffInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询教职工基础档案主列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StaffInfo staffInfo)
    {
        startPage();
        List<StaffInfo> list = staffInfoService.selectStaffInfoList(staffInfo);
        return getDataTable(list);
    }

    /**
     * 导出教职工基础档案主列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "教职工基础档案主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StaffInfo staffInfo)
    {
        List<StaffInfo> list = staffInfoService.selectStaffInfoList(staffInfo);
        ExcelUtil<StaffInfo> util = new ExcelUtil<StaffInfo>(StaffInfo.class);
        return util.exportExcel(list, "教职工基础档案主数据");
    }

    /**
     * 新增教职工基础档案主
     */
    @RequiresPermissions("system:info:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教职工基础档案主
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "教职工基础档案主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StaffInfo staffInfo)
    {
        return toAjax(staffInfoService.insertStaffInfo(staffInfo));
    }

    /**
     * 修改教职工基础档案主
     */
    @RequiresPermissions("system:info:edit")
    @GetMapping("/edit/{staffId}")
    public String edit(@PathVariable("staffId") String staffId, ModelMap mmap)
    {
        StaffInfo staffInfo = staffInfoService.selectStaffInfoByStaffId(staffId);
        mmap.put("staffInfo", staffInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存教职工基础档案主
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "教职工基础档案主", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StaffInfo staffInfo)
    {
        return toAjax(staffInfoService.updateStaffInfo(staffInfo));
    }

    /**
     * 删除教职工基础档案主
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "教职工基础档案主", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(staffInfoService.deleteStaffInfoByStaffIds(ids));
    }
}
