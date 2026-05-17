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
import com.ruoyi.system.domain.CollegeInfo;
import com.ruoyi.system.service.ICollegeInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学院信息Controller
 * 
 * @author ruoyi
 * @date 2026-04-22
 */
@Controller
@RequestMapping("/CollegeManagement/CollegeInfo")
public class CollegeInfoController extends BaseController
{
    private String prefix = "system/CollegeInfo";

    @Autowired
    private ICollegeInfoService collegeInfoService;

    @RequiresPermissions("CollegeManagement:CollegeInfo:view")
    @GetMapping()
    public String CollegeInfo()
    {
        return prefix + "/CollegeInfo";
    }

    /**
     * 查询学院信息列表
     */
    @RequiresPermissions("CollegeManagement:CollegeInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CollegeInfo collegeInfo)
    {
        startPage();
        List<CollegeInfo> list = collegeInfoService.selectCollegeInfoList(collegeInfo);
        return getDataTable(list);
    }

    /**
     * 导出学院信息列表
     */
    @RequiresPermissions("CollegeManagement:CollegeInfo:export")
    @Log(title = "学院信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CollegeInfo collegeInfo)
    {
        List<CollegeInfo> list = collegeInfoService.selectCollegeInfoList(collegeInfo);
        ExcelUtil<CollegeInfo> util = new ExcelUtil<CollegeInfo>(CollegeInfo.class);
        return util.exportExcel(list, "学院信息数据");
    }

    /**
     * 新增学院信息
     */
    @RequiresPermissions("CollegeManagement:CollegeInfo:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学院信息
     */
    @RequiresPermissions("CollegeManagement:CollegeInfo:add")
    @Log(title = "学院信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CollegeInfo collegeInfo)
    {
        return toAjax(collegeInfoService.insertCollegeInfo(collegeInfo));
    }

    /**
     * 修改学院信息
     */
    @RequiresPermissions("CollegeManagement:CollegeInfo:edit")
    @GetMapping("/edit/{collegeId}")
    public String edit(@PathVariable("collegeId") Long collegeId, ModelMap mmap)
    {
        CollegeInfo collegeInfo = collegeInfoService.selectCollegeInfoByCollegeId(collegeId);
        mmap.put("collegeInfo", collegeInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存学院信息
     */
    @RequiresPermissions("CollegeManagement:CollegeInfo:edit")
    @Log(title = "学院信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CollegeInfo collegeInfo)
    {
        return toAjax(collegeInfoService.updateCollegeInfo(collegeInfo));
    }

    /**
     * 删除学院信息
     */
    @RequiresPermissions("CollegeManagement:CollegeInfo:remove")
    @Log(title = "学院信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(collegeInfoService.deleteCollegeInfoByCollegeIds(ids));
    }
}
