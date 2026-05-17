package com.ruoyi.visual.service;

import java.util.Map;

/**
 * 数据可视化服务接口
 * 
 * @author ruoyi
 * @date 2026-05-12
 */
public interface IVisualService {

    /**
     * 获取学生可视化图表数据
     * 
     * @param dataType 数据类型（如：gender、birthDate、ethnic等）
     * @param chartType 图表类型（pie：饼图，bar：柱状图）
     * @return 图表数据
     */
    Map<String, Object> getChartData(String dataType, String chartType);

    /**
     * 获取教职工可视化图表数据
     * 
     * @param dataType 数据类型（如：staffType、department、jobTitle等）
     * @param chartType 图表类型（pie：饼图，bar：柱状图）
     * @return 图表数据
     */
    Map<String, Object> getStaffChartData(String dataType, String chartType);

    /**
     * 获取学生可用的数据类型列表
     * 
     * @return 数据类型列表
     */
    Map<String, String> getAvailableDataTypes();

    /**
     * 获取教职工可用的数据类型列表
     * 
     * @return 数据类型列表
     */
    Map<String, String> getAvailableStaffDataTypes();

    /**
     * 获取宿舍可视化图表数据
     * 
     * @param dataType 数据类型（如：dormType、building、floorNum等）
     * @param chartType 图表类型（pie：饼图，bar：柱状图）
     * @return 图表数据
     */
    Map<String, Object> getDormChartData(String dataType, String chartType);

    /**
     * 获取宿舍可用的数据类型列表
     * 
     * @return 数据类型列表
     */
    Map<String, String> getAvailableDormDataTypes();

    /**
     * 获取食堂档口可视化图表数据
     * 
     * @param dataType 数据类型（如：canteenName、hygieneStatus等）
     * @param chartType 图表类型（pie：饼图，bar：柱状图）
     * @return 图表数据
     */
    Map<String, Object> getStallChartData(String dataType, String chartType);

    /**
     * 获取食堂档口可用的数据类型列表
     * 
     * @return 数据类型列表
     */
    Map<String, String> getAvailableStallDataTypes();
}
