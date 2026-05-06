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
import com.ruoyi.system.domain.StudentMoral;
import com.ruoyi.system.service.IStudentMoralService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生德育考核管理Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/moral")
public class StudentMoralController extends BaseController
{
    private String prefix = "system/moral";

    @Autowired
    private IStudentMoralService studentMoralService;

    @RequiresPermissions("system:moral:view")
    @GetMapping()
    public String moral()
    {
        return prefix + "/moral";
    }

    /**
     * 查询学生德育考核管理列表
     */
    @RequiresPermissions("system:moral:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentMoral studentMoral)
    {
        startPage();
        List<StudentMoral> list = studentMoralService.selectStudentMoralList(studentMoral);
        return getDataTable(list);
    }

    /**
     * 导出学生德育考核管理列表
     */
    @RequiresPermissions("system:moral:export")
    @Log(title = "学生德育考核管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentMoral studentMoral)
    {
        List<StudentMoral> list = studentMoralService.selectStudentMoralList(studentMoral);
        ExcelUtil<StudentMoral> util = new ExcelUtil<StudentMoral>(StudentMoral.class);
        return util.exportExcel(list, "学生德育考核管理数据");
    }

    /**
     * 新增学生德育考核管理
     */
    @RequiresPermissions("system:moral:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生德育考核管理
     */
    @RequiresPermissions("system:moral:add")
    @Log(title = "学生德育考核管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentMoral studentMoral)
    {
        return toAjax(studentMoralService.insertStudentMoral(studentMoral));
    }

    /**
     * 修改学生德育考核管理
     */
    @RequiresPermissions("system:moral:edit")
    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") String studentId, ModelMap mmap)
    {
        StudentMoral studentMoral = studentMoralService.selectStudentMoralByStudentId(studentId);
        mmap.put("studentMoral", studentMoral);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生德育考核管理
     */
    @RequiresPermissions("system:moral:edit")
    @Log(title = "学生德育考核管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentMoral studentMoral)
    {
        return toAjax(studentMoralService.updateStudentMoral(studentMoral));
    }

    /**
     * 删除学生德育考核管理
     */
    @RequiresPermissions("system:moral:remove")
    @Log(title = "学生德育考核管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentMoralService.deleteStudentMoralByStudentIds(ids));
    }
}
