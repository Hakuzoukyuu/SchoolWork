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
import com.ruoyi.system.domain.StudentMental;
import com.ruoyi.system.service.IStudentMentalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生心理健康Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/mental")
public class StudentMentalController extends BaseController
{
    private String prefix = "system/mental";

    @Autowired
    private IStudentMentalService studentMentalService;

    @RequiresPermissions("system:mental:view")
    @GetMapping()
    public String mental()
    {
        return prefix + "/mental";
    }

    /**
     * 查询学生心理健康列表
     */
    @RequiresPermissions("system:mental:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentMental studentMental)
    {
        startPage();
        List<StudentMental> list = studentMentalService.selectStudentMentalList(studentMental);
        return getDataTable(list);
    }

    /**
     * 导出学生心理健康列表
     */
    @RequiresPermissions("system:mental:export")
    @Log(title = "学生心理健康", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentMental studentMental)
    {
        List<StudentMental> list = studentMentalService.selectStudentMentalList(studentMental);
        ExcelUtil<StudentMental> util = new ExcelUtil<StudentMental>(StudentMental.class);
        return util.exportExcel(list, "学生心理健康数据");
    }

    /**
     * 新增学生心理健康
     */
    @RequiresPermissions("system:mental:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生心理健康
     */
    @RequiresPermissions("system:mental:add")
    @Log(title = "学生心理健康", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentMental studentMental)
    {
        return toAjax(studentMentalService.insertStudentMental(studentMental));
    }

    /**
     * 修改学生心理健康
     */
    @RequiresPermissions("system:mental:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        StudentMental studentMental = studentMentalService.selectStudentMentalById(id);
        mmap.put("studentMental", studentMental);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生心理健康
     */
    @RequiresPermissions("system:mental:edit")
    @Log(title = "学生心理健康", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentMental studentMental)
    {
        return toAjax(studentMentalService.updateStudentMental(studentMental));
    }

    /**
     * 删除学生心理健康
     */
    @RequiresPermissions("system:mental:remove")
    @Log(title = "学生心理健康", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentMentalService.deleteStudentMentalByIds(ids));
    }
}
