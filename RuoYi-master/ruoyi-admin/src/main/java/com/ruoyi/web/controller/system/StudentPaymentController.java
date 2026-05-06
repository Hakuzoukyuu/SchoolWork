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
import com.ruoyi.system.domain.StudentPayment;
import com.ruoyi.system.service.IStudentPaymentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生缴费Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/payment")
public class StudentPaymentController extends BaseController
{
    private String prefix = "system/payment";

    @Autowired
    private IStudentPaymentService studentPaymentService;

    @RequiresPermissions("system:payment:view")
    @GetMapping()
    public String payment()
    {
        return prefix + "/payment";
    }

    /**
     * 查询学生缴费列表
     */
    @RequiresPermissions("system:payment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StudentPayment studentPayment)
    {
        startPage();
        List<StudentPayment> list = studentPaymentService.selectStudentPaymentList(studentPayment);
        return getDataTable(list);
    }

    /**
     * 导出学生缴费列表
     */
    @RequiresPermissions("system:payment:export")
    @Log(title = "学生缴费", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StudentPayment studentPayment)
    {
        List<StudentPayment> list = studentPaymentService.selectStudentPaymentList(studentPayment);
        ExcelUtil<StudentPayment> util = new ExcelUtil<StudentPayment>(StudentPayment.class);
        return util.exportExcel(list, "学生缴费数据");
    }

    /**
     * 新增学生缴费
     */
    @RequiresPermissions("system:payment:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生缴费
     */
    @RequiresPermissions("system:payment:add")
    @Log(title = "学生缴费", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StudentPayment studentPayment)
    {
        return toAjax(studentPaymentService.insertStudentPayment(studentPayment));
    }

    /**
     * 修改学生缴费
     */
    @RequiresPermissions("system:payment:edit")
    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") String studentId, ModelMap mmap)
    {
        StudentPayment studentPayment = studentPaymentService.selectStudentPaymentByStudentId(studentId);
        mmap.put("studentPayment", studentPayment);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生缴费
     */
    @RequiresPermissions("system:payment:edit")
    @Log(title = "学生缴费", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StudentPayment studentPayment)
    {
        return toAjax(studentPaymentService.updateStudentPayment(studentPayment));
    }

    /**
     * 删除学生缴费
     */
    @RequiresPermissions("system:payment:remove")
    @Log(title = "学生缴费", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(studentPaymentService.deleteStudentPaymentByStudentIds(ids));
    }
}
