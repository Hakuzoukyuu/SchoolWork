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
import com.ruoyi.system.domain.RecruitAdmission;
import com.ruoyi.system.service.IRecruitAdmissionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 招生管理(志愿通过-未正式录取学生)Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/admission")
public class RecruitAdmissionController extends BaseController
{
    private String prefix = "system/admission";

    @Autowired
    private IRecruitAdmissionService recruitAdmissionService;

    @RequiresPermissions("system:admission:view")
    @GetMapping()
    public String admission()
    {
        return prefix + "/admission";
    }

    /**
     * 查询招生管理(志愿通过-未正式录取学生)列表
     */
    @RequiresPermissions("system:admission:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecruitAdmission recruitAdmission)
    {
        startPage();
        List<RecruitAdmission> list = recruitAdmissionService.selectRecruitAdmissionList(recruitAdmission);
        return getDataTable(list);
    }

    /**
     * 导出招生管理(志愿通过-未正式录取学生)列表
     */
    @RequiresPermissions("system:admission:export")
    @Log(title = "招生管理(志愿通过-未正式录取学生)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecruitAdmission recruitAdmission)
    {
        List<RecruitAdmission> list = recruitAdmissionService.selectRecruitAdmissionList(recruitAdmission);
        ExcelUtil<RecruitAdmission> util = new ExcelUtil<RecruitAdmission>(RecruitAdmission.class);
        return util.exportExcel(list, "招生管理(志愿通过-未正式录取学生)数据");
    }

    /**
     * 新增招生管理(志愿通过-未正式录取学生)
     */
    @RequiresPermissions("system:admission:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存招生管理(志愿通过-未正式录取学生)
     */
    @RequiresPermissions("system:admission:add")
    @Log(title = "招生管理(志愿通过-未正式录取学生)", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecruitAdmission recruitAdmission)
    {
        return toAjax(recruitAdmissionService.insertRecruitAdmission(recruitAdmission));
    }

    /**
     * 修改招生管理(志愿通过-未正式录取学生)
     */
    @RequiresPermissions("system:admission:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RecruitAdmission recruitAdmission = recruitAdmissionService.selectRecruitAdmissionById(id);
        mmap.put("recruitAdmission", recruitAdmission);
        return prefix + "/edit";
    }

    /**
     * 修改保存招生管理(志愿通过-未正式录取学生)
     */
    @RequiresPermissions("system:admission:edit")
    @Log(title = "招生管理(志愿通过-未正式录取学生)", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecruitAdmission recruitAdmission)
    {
        return toAjax(recruitAdmissionService.updateRecruitAdmission(recruitAdmission));
    }

    /**
     * 删除招生管理(志愿通过-未正式录取学生)
     */
    @RequiresPermissions("system:admission:remove")
    @Log(title = "招生管理(志愿通过-未正式录取学生)", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recruitAdmissionService.deleteRecruitAdmissionByIds(ids));
    }
}
