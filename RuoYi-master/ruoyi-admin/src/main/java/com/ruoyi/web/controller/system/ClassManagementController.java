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
import com.ruoyi.system.domain.ClassManagement;
import com.ruoyi.system.service.IClassManagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班级管理Controller
 *
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
// 🔥 只改这里：把冲突的路径改为唯一的 /system/class
@RequestMapping("/system/class")
public class ClassManagementController extends BaseController
{
    // ✅ 完全不动！对应你的页面文件夹 system/management
    private String prefix = "system/management";

    @Autowired
    private IClassManagementService classManagementService;

    // 🔥 权限标识改为唯一，避免冲突
    @RequiresPermissions("system:class:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 查询班级管理列表
     */
    @RequiresPermissions("system:class:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClassManagement classManagement)
    {
        startPage();
        List<ClassManagement> list = classManagementService.selectClassManagementList(classManagement);
        return getDataTable(list);
    }

    /**
     * 导出班级管理列表
     */
    @RequiresPermissions("system:class:export")
    @Log(title = "班级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClassManagement classManagement)
    {
        List<ClassManagement> list = classManagementService.selectClassManagementList(classManagement);
        ExcelUtil<ClassManagement> util = new ExcelUtil<ClassManagement>(ClassManagement.class);
        return util.exportExcel(list, "班级管理数据");
    }

    /**
     * 新增班级管理
     */
    @RequiresPermissions("system:class:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存班级管理
     */
    @RequiresPermissions("system:class:add")
    @Log(title = "班级管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClassManagement classManagement)
    {
        return toAjax(classManagementService.insertClassManagement(classManagement));
    }

    /**
     * 修改班级管理
     */
    @RequiresPermissions("system:class:edit")
    @GetMapping("/edit/{classId}")
    public String edit(@PathVariable("classId") Long classId, ModelMap mmap)
    {
        ClassManagement classManagement = classManagementService.selectClassManagementByClassId(classId);
        mmap.put("classManagement", classManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存班级管理
     */
    @RequiresPermissions("system:class:edit")
    @Log(title = "班级管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClassManagement classManagement)
    {
        return toAjax(classManagementService.updateClassManagement(classManagement));
    }

    /**
     * 删除班级管理
     */
    @RequiresPermissions("system:class:remove")
    @Log(title = "班级管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(classManagementService.deleteClassManagementByClassIds(ids));
    }
}