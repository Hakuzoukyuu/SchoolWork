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
import com.ruoyi.system.domain.OfficeNotice;
import com.ruoyi.system.service.IOfficeNoticeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 行政办公通知Controller
 */
@Controller
// 🔥 修改1：接口路径改成唯一，避开系统自带的 /system/notice
@RequestMapping("/system/officeNotice")
public class OfficeNoticeController extends BaseController
{
    // 🔥 修改2：页面前缀严格匹配你的文件夹：system/noticemanagement
    private String prefix = "system/noticemanagement";

    @Autowired
    private IOfficeNoticeService officeNoticeService;

    // 🔥 修改3：权限标识同步修改，避免冲突
    @RequiresPermissions("system:officeNotice:view")
    @GetMapping()
    public String notice()
    {
        return prefix + "/notice";
    }

    /**
     * 查询行政办公通知列表
     */
    @RequiresPermissions("system:officeNotice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OfficeNotice officeNotice)
    {
        startPage();
        List<OfficeNotice> list = officeNoticeService.selectOfficeNoticeList(officeNotice);
        return getDataTable(list);
    }

    /**
     * 导出行政办公通知列表
     */
    @RequiresPermissions("system:officeNotice:export")
    @Log(title = "行政办公通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OfficeNotice officeNotice)
    {
        List<OfficeNotice> list = officeNoticeService.selectOfficeNoticeList(officeNotice);
        ExcelUtil<OfficeNotice> util = new ExcelUtil<>(OfficeNotice.class);
        return util.exportExcel(list, "行政办公通知数据");
    }

    /**
     * 新增行政办公通知
     */
    @RequiresPermissions("system:officeNotice:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存行政办公通知
     */
    @RequiresPermissions("system:officeNotice:add")
    @Log(title = "行政办公通知", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OfficeNotice officeNotice)
    {
        return toAjax(officeNoticeService.insertOfficeNotice(officeNotice));
    }

    /**
     * 修改行政办公通知
     */
    @RequiresPermissions("system:officeNotice:edit")
    @GetMapping("/edit/{noticeId}")
    public String edit(@PathVariable("noticeId") Long noticeId, ModelMap mmap)
    {
        OfficeNotice officeNotice = officeNoticeService.selectOfficeNoticeByNoticeId(noticeId);
        mmap.put("officeNotice", officeNotice);
        return prefix + "/edit";
    }

    /**
     * 修改保存行政办公通知
     */
    @RequiresPermissions("system:officeNotice:edit")
    @Log(title = "行政办公通知", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OfficeNotice officeNotice)
    {
        return toAjax(officeNoticeService.updateOfficeNotice(officeNotice));
    }

    /**
     * 删除行政办公通知
     */
    @RequiresPermissions("system:officeNotice:remove")
    @Log(title = "行政办公通知", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(officeNoticeService.deleteOfficeNoticeByNoticeIds(ids));
    }
}