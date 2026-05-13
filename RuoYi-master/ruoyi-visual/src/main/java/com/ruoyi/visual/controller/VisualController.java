package com.ruoyi.visual.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.visual.service.IVisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 数据可视化Controller
 * 
 * @author ruoyi
 * @date 2026-05-12
 */
@RestController
@RequestMapping("/visual")
public class VisualController extends BaseController {

    @Autowired
    private IVisualService visualService;

    /**
     * 获取图表数据
     * 
     * @param dataType 数据类型（gender/birthDate/ethnic/political/bloodType）
     * @param chartType 图表类型（pie/bar）
     * @return 图表数据
     */
    @GetMapping("/chart")
    public AjaxResult getChartData(
            @RequestParam("dataType") String dataType,
            @RequestParam("chartType") String chartType) {
        
        Map<String, Object> result = visualService.getChartData(dataType, chartType);
        
        if ((Boolean) result.get("success")) {
            return AjaxResult.success(result);
        } else {
            return AjaxResult.error((String) result.get("message"));
        }
    }

    /**
     * 获取学生可用的数据类型列表
     * 
     * @return 数据类型列表
     */
    @GetMapping("/dataTypes")
    public AjaxResult getAvailableDataTypes() {
        return AjaxResult.success(visualService.getAvailableDataTypes());
    }

    /**
     * 获取教职工图表数据
     * 
     * @param dataType 数据类型（staffType/department/jobTitle/education/contractType/staffStatus）
     * @param chartType 图表类型（pie/bar）
     * @return 图表数据
     */
    @GetMapping("/staff/chart")
    public AjaxResult getStaffChartData(
            @RequestParam("dataType") String dataType,
            @RequestParam("chartType") String chartType) {
        
        Map<String, Object> result = visualService.getStaffChartData(dataType, chartType);
        
        if ((Boolean) result.get("success")) {
            return AjaxResult.success(result);
        } else {
            return AjaxResult.error((String) result.get("message"));
        }
    }

    /**
     * 获取教职工可用的数据类型列表
     * 
     * @return 数据类型列表
     */
    @GetMapping("/staff/dataTypes")
    public AjaxResult getAvailableStaffDataTypes() {
        return AjaxResult.success(visualService.getAvailableStaffDataTypes());
    }

    /**
     * 获取宿舍图表数据
     * 
     * @param dataType 数据类型（dormType/building/floorNum/dormHygiene/dormCheckStatus/maxBed）
     * @param chartType 图表类型（pie/bar）
     * @return 图表数据
     */
    @GetMapping("/dorm/chart")
    public AjaxResult getDormChartData(
            @RequestParam("dataType") String dataType,
            @RequestParam("chartType") String chartType) {
        
        Map<String, Object> result = visualService.getDormChartData(dataType, chartType);
        
        if ((Boolean) result.get("success")) {
            return AjaxResult.success(result);
        } else {
            return AjaxResult.error((String) result.get("message"));
        }
    }

    /**
     * 获取宿舍可用的数据类型列表
     * 
     * @return 数据类型列表
     */
    @GetMapping("/dorm/dataTypes")
    public AjaxResult getAvailableDormDataTypes() {
        return AjaxResult.success(visualService.getAvailableDormDataTypes());
    }

    /**
     * 获取食堂档口图表数据
     * 
     * @param dataType 数据类型（canteenName/hygieneStatus/manager/checkPeople）
     * @param chartType 图表类型（pie/bar）
     * @return 图表数据
     */
    @GetMapping("/stall/chart")
    public AjaxResult getStallChartData(
            @RequestParam("dataType") String dataType,
            @RequestParam("chartType") String chartType) {
        
        Map<String, Object> result = visualService.getStallChartData(dataType, chartType);
        
        if ((Boolean) result.get("success")) {
            return AjaxResult.success(result);
        } else {
            return AjaxResult.error((String) result.get("message"));
        }
    }

    /**
     * 获取食堂档口可用的数据类型列表
     * 
     * @return 数据类型列表
     */
    @GetMapping("/stall/dataTypes")
    public AjaxResult getAvailableStallDataTypes() {
        return AjaxResult.success(visualService.getAvailableStallDataTypes());
    }
}
