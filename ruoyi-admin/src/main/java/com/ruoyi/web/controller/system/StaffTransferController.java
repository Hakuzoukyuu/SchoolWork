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
import com.ruoyi.system.domain.StaffTransfer;
import com.ruoyi.system.service.IStaffTransferService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教职工调动管理Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/transfer")
public class StaffTransferController extends BaseController
{
    private String prefix = "system/transfer";

    @Autowired
    private IStaffTransferService staffTransferService;

    @RequiresPermissions("system:transfer:view")
    @GetMapping()
    public String transfer()
    {
        return prefix + "/transfer";
    }

    /**
     * 查询教职工调动管理列表
     */
    @RequiresPermissions("system:transfer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StaffTransfer staffTransfer)
    {
        startPage();
        List<StaffTransfer> list = staffTransferService.selectStaffTransferList(staffTransfer);
        return getDataTable(list);
    }

    /**
     * 导出教职工调动管理列表
     */
    @RequiresPermissions("system:transfer:export")
    @Log(title = "教职工调动管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StaffTransfer staffTransfer)
    {
        List<StaffTransfer> list = staffTransferService.selectStaffTransferList(staffTransfer);
        ExcelUtil<StaffTransfer> util = new ExcelUtil<StaffTransfer>(StaffTransfer.class);
        return util.exportExcel(list, "教职工调动管理数据");
    }

    /**
     * 新增教职工调动管理
     */
    @RequiresPermissions("system:transfer:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教职工调动管理
     */
    @RequiresPermissions("system:transfer:add")
    @Log(title = "教职工调动管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StaffTransfer staffTransfer)
    {
        return toAjax(staffTransferService.insertStaffTransfer(staffTransfer));
    }

    /**
     * 修改教职工调动管理
     */
    @RequiresPermissions("system:transfer:edit")
    @GetMapping("/edit/{transferId}")
    public String edit(@PathVariable("transferId") Long transferId, ModelMap mmap)
    {
        StaffTransfer staffTransfer = staffTransferService.selectStaffTransferByTransferId(transferId);
        mmap.put("staffTransfer", staffTransfer);
        return prefix + "/edit";
    }

    /**
     * 修改保存教职工调动管理
     */
    @RequiresPermissions("system:transfer:edit")
    @Log(title = "教职工调动管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StaffTransfer staffTransfer)
    {
        return toAjax(staffTransferService.updateStaffTransfer(staffTransfer));
    }

    /**
     * 删除教职工调动管理
     */
    @RequiresPermissions("system:transfer:remove")
    @Log(title = "教职工调动管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(staffTransferService.deleteStaffTransferByTransferIds(ids));
    }
}
