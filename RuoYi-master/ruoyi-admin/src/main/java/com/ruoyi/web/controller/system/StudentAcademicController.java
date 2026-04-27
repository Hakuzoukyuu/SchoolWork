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
import com.ruoyi.system.domain.StudentAcademic;
import com.ruoyi.system.service.IStudentAcademicService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学籍信息Controller
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
@Controller
@RequestMapping("/system/academic")
public class StudentAcademicController extends BaseController
{
    private String prefix = "system/academic";

    @Autowired
    private IStudentAcademicService studentAcademicService;

    @RequiresPermissions("system:academic:view")
    @GetMapping()
    public String academic()
    {
        return prefix + "/academic";
    }

    /**
     * 查询学籍信息列表
     */
    @RequiresPermissions("system:academic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentAcademic studentAcademic)
    {
        startPage();
        List<StudentAcademic> list = studentAcademicService.selectStudentAcademicList(studentAcademic);
        return getDataTable(list);
    }

    /**
     * 导出学籍信息列表
     */
    @RequiresPermissions("system:academic:export")
    @Log(title = "学籍信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentAcademic studentAcademic)
    {
        List<StudentAcademic> list = studentAcademicService.selectStudentAcademicList(studentAcademic);
        ExcelUtil<StudentAcademic> util = new ExcelUtil<StudentAcademic>(StudentAcademic.class);
        return util.exportExcel(list, "学籍信息数据");
    }

    /**
     * 新增学籍信息
     */
    @RequiresPermissions("system:academic:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学籍信息
     */
    @RequiresPermissions("system:academic:add")
    @Log(title = "学籍信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentAcademic studentAcademic)
    {
        return toAjax(studentAcademicService.insertStudentAcademic(studentAcademic));
    }

    /**
     * 修改学籍信息
     */
    @RequiresPermissions("system:academic:edit")
    @GetMapping("/edit/{academicId}")
    public String edit(@PathVariable("academicId") Long academicId, ModelMap mmap)
    {
        StudentAcademic studentAcademic = studentAcademicService.selectStudentAcademicByAcademicId(academicId);
        mmap.put("studentAcademic", studentAcademic);
        return prefix + "/edit";
    }

    /**
     * 修改保存学籍信息
     */
    @RequiresPermissions("system:academic:edit")
    @Log(title = "学籍信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentAcademic studentAcademic)
    {
        return toAjax(studentAcademicService.updateStudentAcademic(studentAcademic));
    }

    /**
     * 删除学籍信息
     */
    @RequiresPermissions("system:academic:remove")
    @Log(title = "学籍信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentAcademicService.deleteStudentAcademicByAcademicIds(ids));
    }
}
