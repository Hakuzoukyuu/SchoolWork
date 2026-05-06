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
import com.ruoyi.system.domain.OfficeDocument;
import com.ruoyi.system.service.IOfficeDocumentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公文流转Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/document")
public class OfficeDocumentController extends BaseController
{
    private String prefix = "system/document";

    @Autowired
    private IOfficeDocumentService officeDocumentService;

    @RequiresPermissions("system:document:view")
    @GetMapping()
    public String document()
    {
        return prefix + "/document";
    }

    /**
     * 查询公文流转列表
     */
    @RequiresPermissions("system:document:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OfficeDocument officeDocument)
    {
        startPage();
        List<OfficeDocument> list = officeDocumentService.selectOfficeDocumentList(officeDocument);
        return getDataTable(list);
    }

    /**
     * 导出公文流转列表
     */
    @RequiresPermissions("system:document:export")
    @Log(title = "公文流转", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OfficeDocument officeDocument)
    {
        List<OfficeDocument> list = officeDocumentService.selectOfficeDocumentList(officeDocument);
        ExcelUtil<OfficeDocument> util = new ExcelUtil<OfficeDocument>(OfficeDocument.class);
        return util.exportExcel(list, "公文流转数据");
    }

    /**
     * 新增公文流转
     */
    @RequiresPermissions("system:document:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存公文流转
     */
    @RequiresPermissions("system:document:add")
    @Log(title = "公文流转", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OfficeDocument officeDocument)
    {
        return toAjax(officeDocumentService.insertOfficeDocument(officeDocument));
    }

    /**
     * 修改公文流转
     */
    @RequiresPermissions("system:document:edit")
    @GetMapping("/edit/{docId}")
    public String edit(@PathVariable("docId") Long docId, ModelMap mmap)
    {
        OfficeDocument officeDocument = officeDocumentService.selectOfficeDocumentByDocId(docId);
        mmap.put("officeDocument", officeDocument);
        return prefix + "/edit";
    }

    /**
     * 修改保存公文流转
     */
    @RequiresPermissions("system:document:edit")
    @Log(title = "公文流转", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OfficeDocument officeDocument)
    {
        return toAjax(officeDocumentService.updateOfficeDocument(officeDocument));
    }

    /**
     * 删除公文流转
     */
    @RequiresPermissions("system:document:remove")
    @Log(title = "公文流转", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(officeDocumentService.deleteOfficeDocumentByDocIds(ids));
    }
}
