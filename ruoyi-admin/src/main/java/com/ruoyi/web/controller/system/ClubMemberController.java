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
import com.ruoyi.system.domain.ClubMember;
import com.ruoyi.system.service.IClubMemberService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社团成员表Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/member")
public class ClubMemberController extends BaseController
{
    private String prefix = "system/member";

    @Autowired
    private IClubMemberService clubMemberService;

    @RequiresPermissions("system:member:view")
    @GetMapping()
    public String member()
    {
        return prefix + "/member";
    }

    /**
     * 查询社团成员表列表
     */
    @RequiresPermissions("system:member:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClubMember clubMember)
    {
        startPage();
        List<ClubMember> list = clubMemberService.selectClubMemberList(clubMember);
        return getDataTable(list);
    }

    /**
     * 导出社团成员表列表
     */
    @RequiresPermissions("system:member:export")
    @Log(title = "社团成员表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClubMember clubMember)
    {
        List<ClubMember> list = clubMemberService.selectClubMemberList(clubMember);
        ExcelUtil<ClubMember> util = new ExcelUtil<ClubMember>(ClubMember.class);
        return util.exportExcel(list, "社团成员表数据");
    }

    /**
     * 新增社团成员表
     */
    @RequiresPermissions("system:member:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社团成员表
     */
    @RequiresPermissions("system:member:add")
    @Log(title = "社团成员表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClubMember clubMember)
    {
        return toAjax(clubMemberService.insertClubMember(clubMember));
    }

    /**
     * 修改社团成员表
     */
    @RequiresPermissions("system:member:edit")
    @GetMapping("/edit/{memberId}")
    public String edit(@PathVariable("memberId") Long memberId, ModelMap mmap)
    {
        ClubMember clubMember = clubMemberService.selectClubMemberByMemberId(memberId);
        mmap.put("clubMember", clubMember);
        return prefix + "/edit";
    }

    /**
     * 修改保存社团成员表
     */
    @RequiresPermissions("system:member:edit")
    @Log(title = "社团成员表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClubMember clubMember)
    {
        return toAjax(clubMemberService.updateClubMember(clubMember));
    }

    /**
     * 删除社团成员表
     */
    @RequiresPermissions("system:member:remove")
    @Log(title = "社团成员表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(clubMemberService.deleteClubMemberByMemberIds(ids));
    }
}
