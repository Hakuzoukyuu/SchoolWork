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
import com.ruoyi.system.domain.StudentFamily;
import com.ruoyi.system.service.IStudentFamilyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 家庭信息Controller
 * 
 * @author ruoyi
 * @date 2026-04-15
 */
@Controller
@RequestMapping("/system/family")
public class StudentFamilyController extends BaseController
{
    private String prefix = "system/family";

    @Autowired
    private IStudentFamilyService studentFamilyService;

    @RequiresPermissions("system:family:view")
    @GetMapping()
    public String family()
    {
        return prefix + "/family";
    }

    /**
     * 查询家庭信息列表
     */
    @RequiresPermissions("system:family:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentFamily studentFamily)
    {
        startPage();
        List<StudentFamily> list = studentFamilyService.selectStudentFamilyList(studentFamily);
        return getDataTable(list);
    }

    /**
     * 导出家庭信息列表
     */
    @RequiresPermissions("system:family:export")
    @Log(title = "家庭信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentFamily studentFamily)
    {
        List<StudentFamily> list = studentFamilyService.selectStudentFamilyList(studentFamily);
        ExcelUtil<StudentFamily> util = new ExcelUtil<StudentFamily>(StudentFamily.class);
        return util.exportExcel(list, "家庭信息数据");
    }

    /**
     * 新增家庭信息
     */
    @RequiresPermissions("system:family:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存家庭信息
     */
    @RequiresPermissions("system:family:add")
    @Log(title = "家庭信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentFamily studentFamily)
    {
        return toAjax(studentFamilyService.insertStudentFamily(studentFamily));
    }

    /**
     * 修改家庭信息
     */
    @RequiresPermissions("system:family:edit")
    @GetMapping("/edit/{familyId}")
    public String edit(@PathVariable("familyId") Long familyId, ModelMap mmap)
    {
        StudentFamily studentFamily = studentFamilyService.selectStudentFamilyByFamilyId(familyId);
        mmap.put("studentFamily", studentFamily);
        return prefix + "/edit";
    }

    /**
     * 修改保存家庭信息
     */
    @RequiresPermissions("system:family:edit")
    @Log(title = "家庭信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentFamily studentFamily)
    {
        return toAjax(studentFamilyService.updateStudentFamily(studentFamily));
    }

    /**
     * 删除家庭信息
     */
    @RequiresPermissions("system:family:remove")
    @Log(title = "家庭信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentFamilyService.deleteStudentFamilyByFamilyIds(ids));
    }
}
