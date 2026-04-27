package com.ruoyi.StudentManagement.controller;

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
import com.ruoyi.StudentManagement.domain.StudentAccommodation;
import com.ruoyi.StudentManagement.service.IStudentAccommodationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生住宿信息Controller
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
@Controller
@RequestMapping("/StudentManagement/accommodation")
public class StudentAccommodationController extends BaseController
{
    private String prefix = "StudentManagement/accommodation";

    @Autowired
    private IStudentAccommodationService studentAccommodationService;

    @RequiresPermissions("StudentManagement:accommodation:view")
    @GetMapping()
    public String accommodation()
    {
        return prefix + "/accommodation";
    }

    /**
     * 查询学生住宿信息列表
     */
    @RequiresPermissions("StudentManagement:accommodation:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentAccommodation studentAccommodation)
    {
        startPage();
        List<StudentAccommodation> list = studentAccommodationService.selectStudentAccommodationList(studentAccommodation);
        return getDataTable(list);
    }

    /**
     * 导出学生住宿信息列表
     */
    @RequiresPermissions("StudentManagement:accommodation:export")
    @Log(title = "学生住宿信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentAccommodation studentAccommodation)
    {
        List<StudentAccommodation> list = studentAccommodationService.selectStudentAccommodationList(studentAccommodation);
        ExcelUtil<StudentAccommodation> util = new ExcelUtil<StudentAccommodation>(StudentAccommodation.class);
        return util.exportExcel(list, "学生住宿信息数据");
    }

    /**
     * 新增学生住宿信息
     */
    @RequiresPermissions("StudentManagement:accommodation:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生住宿信息
     */
    @RequiresPermissions("StudentManagement:accommodation:add")
    @Log(title = "学生住宿信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentAccommodation studentAccommodation)
    {
        return toAjax(studentAccommodationService.insertStudentAccommodation(studentAccommodation));
    }

    /**
     * 修改学生住宿信息
     */
    @RequiresPermissions("StudentManagement:accommodation:edit")
    @GetMapping("/edit/{accommodationId}")
    public String edit(@PathVariable("accommodationId") Long accommodationId, ModelMap mmap)
    {
        StudentAccommodation studentAccommodation = studentAccommodationService.selectStudentAccommodationByAccommodationId(accommodationId);
        mmap.put("studentAccommodation", studentAccommodation);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生住宿信息
     */
    @RequiresPermissions("StudentManagement:accommodation:edit")
    @Log(title = "学生住宿信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentAccommodation studentAccommodation)
    {
        return toAjax(studentAccommodationService.updateStudentAccommodation(studentAccommodation));
    }

    /**
     * 删除学生住宿信息
     */
    @RequiresPermissions("StudentManagement:accommodation:remove")
    @Log(title = "学生住宿信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentAccommodationService.deleteStudentAccommodationByAccommodationIds(ids));
    }
}
