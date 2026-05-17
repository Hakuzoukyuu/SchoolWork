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
import com.ruoyi.system.domain.MeetingManagement;
import com.ruoyi.system.service.IMeetingManagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会议管理Controller
 */
@Controller
// 接口路径保持不变，和菜单一致
@RequestMapping("/system/meetingmanagement")
public class MeetingManagementController extends BaseController
{
    // 🔥 完全匹配你的新页面路径：system/meetingmanagement
    private String prefix = "system/meetingmanagement";

    @Autowired
    private IMeetingManagementService meetingManagementService;

    // 权限标识保持不变
    @RequiresPermissions("system:meeting:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 查询会议管理列表
     */
    @RequiresPermissions("system:meeting:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MeetingManagement meetingManagement)
    {
        startPage();
        List<MeetingManagement> list = meetingManagementService.selectMeetingManagementList(meetingManagement);
        return getDataTable(list);
    }

    /**
     * 导出会议管理列表
     */
    @RequiresPermissions("system:meeting:export")
    @Log(title = "会议管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MeetingManagement meetingManagement)
    {
        List<MeetingManagement> list = meetingManagementService.selectMeetingManagementList(meetingManagement);
        ExcelUtil<MeetingManagement> util = new ExcelUtil<>(MeetingManagement.class);
        return util.exportExcel(list, "会议管理数据");
    }

    /**
     * 新增会议管理
     */
    @RequiresPermissions("system:meeting:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存会议管理
     */
    @RequiresPermissions("system:meeting:add")
    @Log(title = "会议管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MeetingManagement meetingManagement)
    {
        return toAjax(meetingManagementService.insertMeetingManagement(meetingManagement));
    }

    /**
     * 修改会议管理
     */
    @RequiresPermissions("system:meeting:edit")
    @GetMapping("/edit/{meetingId}")
    public String edit(@PathVariable("meetingId") Long meetingId, ModelMap mmap)
    {
        MeetingManagement meetingManagement = meetingManagementService.selectMeetingManagementByMeetingId(meetingId);
        mmap.put("meetingManagement", meetingManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存会议管理
     */
    @RequiresPermissions("system:meeting:edit")
    @Log(title = "会议管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MeetingManagement meetingManagement)
    {
        return toAjax(meetingManagementService.updateMeetingManagement(meetingManagement));
    }

    /**
     * 删除会议管理
     */
    @RequiresPermissions("system:meeting:remove")
    @Log(title = "会议管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(meetingManagementService.deleteMeetingManagementByMeetingIds(ids));
    }
}