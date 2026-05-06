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
import com.ruoyi.system.domain.CompanyCoop;
import com.ruoyi.system.service.ICompanyCoopService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 校企合作(父)Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/coop")
public class CompanyCoopController extends BaseController
{
    private String prefix = "system/coop";

    @Autowired
    private ICompanyCoopService companyCoopService;

    @RequiresPermissions("system:coop:view")
    @GetMapping()
    public String coop()
    {
        return prefix + "/coop";
    }

    /**
     * 查询校企合作(父)列表
     */
    @RequiresPermissions("system:coop:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CompanyCoop companyCoop)
    {
        startPage();
        List<CompanyCoop> list = companyCoopService.selectCompanyCoopList(companyCoop);
        return getDataTable(list);
    }

    /**
     * 导出校企合作(父)列表
     */
    @RequiresPermissions("system:coop:export")
    @Log(title = "校企合作(父)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyCoop companyCoop)
    {
        List<CompanyCoop> list = companyCoopService.selectCompanyCoopList(companyCoop);
        ExcelUtil<CompanyCoop> util = new ExcelUtil<CompanyCoop>(CompanyCoop.class);
        return util.exportExcel(list, "校企合作(父)数据");
    }

    /**
     * 新增校企合作(父)
     */
    @RequiresPermissions("system:coop:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存校企合作(父)
     */
    @RequiresPermissions("system:coop:add")
    @Log(title = "校企合作(父)", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CompanyCoop companyCoop)
    {
        return toAjax(companyCoopService.insertCompanyCoop(companyCoop));
    }

    /**
     * 修改校企合作(父)
     */
    @RequiresPermissions("system:coop:edit")
    @GetMapping("/edit/{companyId}")
    public String edit(@PathVariable("companyId") String companyId, ModelMap mmap)
    {
        CompanyCoop companyCoop = companyCoopService.selectCompanyCoopByCompanyId(companyId);
        mmap.put("companyCoop", companyCoop);
        return prefix + "/edit";
    }

    /**
     * 修改保存校企合作(父)
     */
    @RequiresPermissions("system:coop:edit")
    @Log(title = "校企合作(父)", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CompanyCoop companyCoop)
    {
        return toAjax(companyCoopService.updateCompanyCoop(companyCoop));
    }

    /**
     * 删除校企合作(父)
     */
    @RequiresPermissions("system:coop:remove")
    @Log(title = "校企合作(父)", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(companyCoopService.deleteCompanyCoopByCompanyIds(ids));
    }
}
