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
import com.ruoyi.system.domain.FinancialApproval;
import com.ruoyi.system.service.IFinancialApprovalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 财务审批Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/approval")
public class FinancialApprovalController extends BaseController
{
    private String prefix = "system/approval";

    @Autowired
    private IFinancialApprovalService financialApprovalService;

    @RequiresPermissions("system:approval:view")
    @GetMapping()
    public String approval()
    {
        return prefix + "/approval";
    }

    /**
     * 查询财务审批列表
     */
    @RequiresPermissions("system:approval:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FinancialApproval financialApproval)
    {
        startPage();
        List<FinancialApproval> list = financialApprovalService.selectFinancialApprovalList(financialApproval);
        return getDataTable(list);
    }

    /**
     * 导出财务审批列表
     */
    @RequiresPermissions("system:approval:export")
    @Log(title = "财务审批", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FinancialApproval financialApproval)
    {
        List<FinancialApproval> list = financialApprovalService.selectFinancialApprovalList(financialApproval);
        ExcelUtil<FinancialApproval> util = new ExcelUtil<FinancialApproval>(FinancialApproval.class);
        return util.exportExcel(list, "财务审批数据");
    }

    /**
     * 新增财务审批
     */
    @RequiresPermissions("system:approval:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存财务审批
     */
    @RequiresPermissions("system:approval:add")
    @Log(title = "财务审批", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FinancialApproval financialApproval)
    {
        return toAjax(financialApprovalService.insertFinancialApproval(financialApproval));
    }

    /**
     * 修改财务审批
     */
    @RequiresPermissions("system:approval:edit")
    @GetMapping("/edit/{financialId}")
    public String edit(@PathVariable("financialId") Long financialId, ModelMap mmap)
    {
        FinancialApproval financialApproval = financialApprovalService.selectFinancialApprovalByFinancialId(financialId);
        mmap.put("financialApproval", financialApproval);
        return prefix + "/edit";
    }

    /**
     * 修改保存财务审批
     */
    @RequiresPermissions("system:approval:edit")
    @Log(title = "财务审批", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FinancialApproval financialApproval)
    {
        return toAjax(financialApprovalService.updateFinancialApproval(financialApproval));
    }

    /**
     * 删除财务审批
     */
    @RequiresPermissions("system:approval:remove")
    @Log(title = "财务审批", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(financialApprovalService.deleteFinancialApprovalByFinancialIds(ids));
    }
}
