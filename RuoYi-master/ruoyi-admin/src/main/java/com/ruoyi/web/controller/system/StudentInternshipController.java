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
import com.ruoyi.system.domain.StudentInternship;
import com.ruoyi.system.service.IStudentInternshipService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 企业实习(子)Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/internship")
public class StudentInternshipController extends BaseController
{
    private String prefix = "system/internship";

    @Autowired
    private IStudentInternshipService studentInternshipService;

    @RequiresPermissions("system:internship:view")
    @GetMapping()
    public String internship()
    {
        return prefix + "/internship";
    }

    /**
     * 查询企业实习(子)列表
     */
    @RequiresPermissions("system:internship:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentInternship studentInternship)
    {
        startPage();
        List<StudentInternship> list = studentInternshipService.selectStudentInternshipList(studentInternship);
        return getDataTable(list);
    }

    /**
     * 导出企业实习(子)列表
     */
    @RequiresPermissions("system:internship:export")
    @Log(title = "企业实习(子)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentInternship studentInternship)
    {
        List<StudentInternship> list = studentInternshipService.selectStudentInternshipList(studentInternship);
        ExcelUtil<StudentInternship> util = new ExcelUtil<StudentInternship>(StudentInternship.class);
        return util.exportExcel(list, "企业实习(子)数据");
    }

    /**
     * 新增企业实习(子)
     */
    @RequiresPermissions("system:internship:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存企业实习(子)
     */
    @RequiresPermissions("system:internship:add")
    @Log(title = "企业实习(子)", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentInternship studentInternship)
    {
        return toAjax(studentInternshipService.insertStudentInternship(studentInternship));
    }

    /**
     * 修改企业实习(子)
     */
    @RequiresPermissions("system:internship:edit")
    @GetMapping("/edit/{internshipId}")
    public String edit(@PathVariable("internshipId") String internshipId, ModelMap mmap)
    {
        StudentInternship studentInternship = studentInternshipService.selectStudentInternshipByInternshipId(internshipId);
        mmap.put("studentInternship", studentInternship);
        return prefix + "/edit";
    }

    /**
     * 修改保存企业实习(子)
     */
    @RequiresPermissions("system:internship:edit")
    @Log(title = "企业实习(子)", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentInternship studentInternship)
    {
        return toAjax(studentInternshipService.updateStudentInternship(studentInternship));
    }

    /**
     * 删除企业实习(子)
     */
    @RequiresPermissions("system:internship:remove")
    @Log(title = "企业实习(子)", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentInternshipService.deleteStudentInternshipByInternshipIds(ids));
    }
}
