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
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.service.IClubService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社团管理Controller
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
@Controller
@RequestMapping("/system/club")
public class ClubController extends BaseController
{
    private String prefix = "system/club";

    @Autowired
    private IClubService clubService;

    @RequiresPermissions("system:club:view")
    @GetMapping()
    public String club()
    {
        return prefix + "/club";
    }

    /**
     * 查询社团管理列表
     */
    @RequiresPermissions("system:club:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Club club)
    {
        startPage();
        List<Club> list = clubService.selectClubList(club);
        return getDataTable(list);
    }

    /**
     * 导出社团管理列表
     */
    @RequiresPermissions("system:club:export")
    @Log(title = "社团管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Club club)
    {
        List<Club> list = clubService.selectClubList(club);
        ExcelUtil<Club> util = new ExcelUtil<Club>(Club.class);
        return util.exportExcel(list, "社团管理数据");
    }

    /**
     * 新增社团管理
     */
    @RequiresPermissions("system:club:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社团管理
     */
    @RequiresPermissions("system:club:add")
    @Log(title = "社团管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Club club)
    {
        return toAjax(clubService.insertClub(club));
    }

    /**
     * 修改社团管理
     */
    @RequiresPermissions("system:club:edit")
    @GetMapping("/edit/{clubId}")
    public String edit(@PathVariable("clubId") Long clubId, ModelMap mmap)
    {
        Club club = clubService.selectClubByClubId(clubId);
        mmap.put("club", club);
        return prefix + "/edit";
    }

    /**
     * 修改保存社团管理
     */
    @RequiresPermissions("system:club:edit")
    @Log(title = "社团管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Club club)
    {
        return toAjax(clubService.updateClub(club));
    }

    /**
     * 删除社团管理
     */
    @RequiresPermissions("system:club:remove")
    @Log(title = "社团管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(clubService.deleteClubByClubIds(ids));
    }
}
