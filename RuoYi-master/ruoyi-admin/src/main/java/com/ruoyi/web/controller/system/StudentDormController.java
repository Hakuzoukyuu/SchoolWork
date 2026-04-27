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
import com.ruoyi.system.domain.StudentDorm;
import com.ruoyi.system.service.IStudentDormService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 住宿信息Controller
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
@Controller
@RequestMapping("/system/dorm")
public class StudentDormController extends BaseController
{
    private String prefix = "system/dorm";

    @Autowired
    private IStudentDormService studentDormService;

    @RequiresPermissions("system:dorm:view")
    @GetMapping()
    public String dorm()
    {
        return prefix + "/dorm";
    }

    /**
     * 查询住宿信息列表
     */
    @RequiresPermissions("system:dorm:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentDorm studentDorm)
    {
        startPage();
        List<StudentDorm> list = studentDormService.selectStudentDormList(studentDorm);
        return getDataTable(list);
    }

    /**
     * 导出住宿信息列表
     */
    @RequiresPermissions("system:dorm:export")
    @Log(title = "住宿信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentDorm studentDorm)
    {
        List<StudentDorm> list = studentDormService.selectStudentDormList(studentDorm);
        ExcelUtil<StudentDorm> util = new ExcelUtil<StudentDorm>(StudentDorm.class);
        return util.exportExcel(list, "住宿信息数据");
    }

    /**
     * 新增住宿信息
     */
    @RequiresPermissions("system:dorm:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存住宿信息
     */
    @RequiresPermissions("system:dorm:add")
    @Log(title = "住宿信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentDorm studentDorm)
    {
        return toAjax(studentDormService.insertStudentDorm(studentDorm));
    }

    /**
     * 修改住宿信息
     */
    @RequiresPermissions("system:dorm:edit")
    @GetMapping("/edit/{dormId}")
    public String edit(@PathVariable("dormId") Long dormId, ModelMap mmap)
    {
        StudentDorm studentDorm = studentDormService.selectStudentDormByDormId(dormId);
        mmap.put("studentDorm", studentDorm);
        return prefix + "/edit";
    }

    /**
     * 修改保存住宿信息
     */
    @RequiresPermissions("system:dorm:edit")
    @Log(title = "住宿信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentDorm studentDorm)
    {
        return toAjax(studentDormService.updateStudentDorm(studentDorm));
    }

    /**
     * 删除住宿信息
     */
    @RequiresPermissions("system:dorm:remove")
    @Log(title = "住宿信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentDormService.deleteStudentDormByDormIds(ids));
    }
}
