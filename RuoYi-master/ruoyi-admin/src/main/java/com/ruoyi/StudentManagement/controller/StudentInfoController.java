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
import com.ruoyi.StudentManagement.domain.StudentInfo;
import com.ruoyi.StudentManagement.service.IStudentInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生信息Controller
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
@Controller
@RequestMapping("/StudentManagement/StudentInfo")
public class StudentInfoController extends BaseController
{
    private String prefix = "StudentManagement/StudentInfo";

    @Autowired
    private IStudentInfoService studentInfoService;

    @RequiresPermissions("StudentManagement:StudentInfo:view")
    @GetMapping()
    public String StudentInfo()
    {
        return prefix + "/StudentInfo";
    }

    /**
     * 查询学生信息列表
     */
    @RequiresPermissions("StudentManagement:StudentInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentInfo studentInfo)
    {
        startPage();
        List<StudentInfo> list = studentInfoService.selectStudentInfoList(studentInfo);
        return getDataTable(list);
    }

    /**
     * 导出学生信息列表
     */
    @RequiresPermissions("StudentManagement:StudentInfo:export")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentInfo studentInfo)
    {
        List<StudentInfo> list = studentInfoService.selectStudentInfoList(studentInfo);
        ExcelUtil<StudentInfo> util = new ExcelUtil<StudentInfo>(StudentInfo.class);
        return util.exportExcel(list, "学生信息数据");
    }

    /**
     * 新增学生信息
     */
    @RequiresPermissions("StudentManagement:StudentInfo:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生信息
     */
    @RequiresPermissions("StudentManagement:StudentInfo:add")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentInfo studentInfo)
    {
        return toAjax(studentInfoService.insertStudentInfo(studentInfo));
    }

    /**
     * 修改学生信息
     */
    @RequiresPermissions("StudentManagement:StudentInfo:edit")
    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") Long studentId, ModelMap mmap)
    {
        StudentInfo studentInfo = studentInfoService.selectStudentInfoByStudentId(studentId);
        mmap.put("studentInfo", studentInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生信息
     */
    @RequiresPermissions("StudentManagement:StudentInfo:edit")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentInfo studentInfo)
    {
        return toAjax(studentInfoService.updateStudentInfo(studentInfo));
    }

    /**
     * 删除学生信息
     */
    @RequiresPermissions("StudentManagement:StudentInfo:remove")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentInfoService.deleteStudentInfoByStudentIds(ids));
    }
}
