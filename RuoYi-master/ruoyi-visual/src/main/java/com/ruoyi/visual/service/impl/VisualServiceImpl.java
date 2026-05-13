package com.ruoyi.visual.service.impl;

import com.ruoyi.system.domain.Student;
import com.ruoyi.system.domain.StaffInfo;
import com.ruoyi.system.domain.DormDormitory;
import com.ruoyi.system.domain.CanteenStall;
import com.ruoyi.system.mapper.StudentMapper;
import com.ruoyi.system.mapper.StaffInfoMapper;
import com.ruoyi.system.mapper.DormDormitoryMapper;
import com.ruoyi.system.mapper.CanteenStallMapper;
import com.ruoyi.visual.service.IVisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 数据可视化服务实现类
 * 
 * @author ruoyi
 * @date 2026-05-12
 */
@Service
public class VisualServiceImpl implements IVisualService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StaffInfoMapper staffInfoMapper;

    @Autowired
    private DormDormitoryMapper dormDormitoryMapper;

    @Autowired
    private CanteenStallMapper canteenStallMapper;

    /**
     * 学生数据类型映射
     */
    private static final Map<String, String> STUDENT_DATA_TYPE_MAP = new LinkedHashMap<>();
    static {
        STUDENT_DATA_TYPE_MAP.put("gender", "性别");
        STUDENT_DATA_TYPE_MAP.put("birthDate", "出生日期");
        STUDENT_DATA_TYPE_MAP.put("ethnic", "民族");
        STUDENT_DATA_TYPE_MAP.put("political", "政治面貌");
        STUDENT_DATA_TYPE_MAP.put("bloodType", "血型");
    }

    /**
     * 教职工数据类型映射
     */
    private static final Map<String, String> STAFF_DATA_TYPE_MAP = new LinkedHashMap<>();
    static {
        STAFF_DATA_TYPE_MAP.put("staffType", "人员类型");
        STAFF_DATA_TYPE_MAP.put("department", "所属部门");
        STAFF_DATA_TYPE_MAP.put("jobTitle", "职称");
        STAFF_DATA_TYPE_MAP.put("education", "学历");
        STAFF_DATA_TYPE_MAP.put("contractType", "合同类型");
        STAFF_DATA_TYPE_MAP.put("staffStatus", "在职状态");
    }

    /**
     * 宿舍数据类型映射
     */
    private static final Map<String, String> DORM_DATA_TYPE_MAP = new LinkedHashMap<>();
    static {
        DORM_DATA_TYPE_MAP.put("dormType", "宿舍类型");
        DORM_DATA_TYPE_MAP.put("building", "楼栋名称");
        DORM_DATA_TYPE_MAP.put("floorNum", "楼层");
        DORM_DATA_TYPE_MAP.put("dormHygiene", "卫生评级");
        DORM_DATA_TYPE_MAP.put("dormCheckStatus", "查寝状态");
        DORM_DATA_TYPE_MAP.put("maxBed", "床位数量");
    }

    /**
     * 食堂档口数据类型映射
     */
    private static final Map<String, String> STALL_DATA_TYPE_MAP = new LinkedHashMap<>();
    static {
        STALL_DATA_TYPE_MAP.put("canteenName", "所属食堂");
        STALL_DATA_TYPE_MAP.put("hygieneStatus", "卫生检查结果");
        STALL_DATA_TYPE_MAP.put("manager", "档口负责人");
        STALL_DATA_TYPE_MAP.put("checkPeople", "检查人");
    }

    @Override
    public Map<String, Object> getChartData(String dataType, String chartType) {
        Map<String, Object> result = new HashMap<>();
        
        // 获取所有学生数据
        List<Student> students = studentMapper.selectStudentList(new Student());
        
        if (students == null || students.isEmpty()) {
            result.put("success", false);
            result.put("message", "数据不足，无法绘制图像");
            return result;
        }

        // 根据数据类型进行统计
        Map<String, Long> statistics = new LinkedHashMap<>();
        
        switch (dataType) {
            case "gender":
                statistics = statisticsByGender(students);
                break;
            case "birthDate":
                statistics = statisticsByBirthDate(students);
                break;
            case "ethnic":
                statistics = statisticsByEthnic(students);
                break;
            case "political":
                statistics = statisticsByPolitical(students);
                break;
            case "bloodType":
                statistics = statisticsByBloodType(students);
                break;
            default:
                result.put("success", false);
                result.put("message", "不支持的数据类型");
                return result;
        }

        // 检查数据是否足够
        if (statistics.isEmpty()) {
            result.put("success", false);
            result.put("message", "数据不足，无法绘制图像");
            return result;
        }

        // 根据图表类型构建返回数据
        result.put("success", true);
        result.put("dataType", dataType);
        result.put("chartType", chartType);
        result.put("dataTypeName", STUDENT_DATA_TYPE_MAP.get(dataType));
        
        if ("pie".equals(chartType)) {
            buildPieChartData(result, statistics);
        } else if ("bar".equals(chartType)) {
            buildBarChartData(result, statistics);
        }
        
        return result;
    }

    @Override
    public Map<String, Object> getStaffChartData(String dataType, String chartType) {
        Map<String, Object> result = new HashMap<>();
        
        // 获取所有教职工数据
        List<StaffInfo> staffList = staffInfoMapper.selectStaffInfoList(new StaffInfo());
        
        if (staffList == null || staffList.isEmpty()) {
            result.put("success", false);
            result.put("message", "数据不足，无法绘制图像");
            return result;
        }

        // 根据数据类型进行统计
        Map<String, Long> statistics = new LinkedHashMap<>();
        
        switch (dataType) {
            case "staffType":
                statistics = statisticsByStaffType(staffList);
                break;
            case "department":
                statistics = statisticsByDepartment(staffList);
                break;
            case "jobTitle":
                statistics = statisticsByJobTitle(staffList);
                break;
            case "education":
                statistics = statisticsByEducation(staffList);
                break;
            case "contractType":
                statistics = statisticsByContractType(staffList);
                break;
            case "staffStatus":
                statistics = statisticsByStaffStatus(staffList);
                break;
            default:
                result.put("success", false);
                result.put("message", "不支持的数据类型");
                return result;
        }

        // 检查数据是否足够
        if (statistics.isEmpty()) {
            result.put("success", false);
            result.put("message", "数据不足，无法绘制图像");
            return result;
        }

        // 根据图表类型构建返回数据
        result.put("success", true);
        result.put("dataType", dataType);
        result.put("chartType", chartType);
        result.put("dataTypeName", STAFF_DATA_TYPE_MAP.get(dataType));
        
        if ("pie".equals(chartType)) {
            buildPieChartData(result, statistics);
        } else if ("bar".equals(chartType)) {
            buildBarChartData(result, statistics);
        }
        
        return result;
    }

    @Override
    public Map<String, String> getAvailableDataTypes() {
        return STUDENT_DATA_TYPE_MAP;
    }

    @Override
    public Map<String, String> getAvailableStaffDataTypes() {
        return STAFF_DATA_TYPE_MAP;
    }

    @Override
    public Map<String, Object> getDormChartData(String dataType, String chartType) {
        Map<String, Object> result = new HashMap<>();
        
        // 获取所有宿舍数据
        List<DormDormitory> dormList = dormDormitoryMapper.selectDormDormitoryList(new DormDormitory());
        
        if (dormList == null || dormList.isEmpty()) {
            result.put("success", false);
            result.put("message", "数据不足，无法绘制图像");
            return result;
        }

        // 根据数据类型进行统计
        Map<String, Long> statistics = new LinkedHashMap<>();
        
        switch (dataType) {
            case "dormType":
                statistics = statisticsByDormType(dormList);
                break;
            case "building":
                statistics = statisticsByBuilding(dormList);
                break;
            case "floorNum":
                statistics = statisticsByFloorNum(dormList);
                break;
            case "dormHygiene":
                statistics = statisticsByDormHygiene(dormList);
                break;
            case "dormCheckStatus":
                statistics = statisticsByDormCheckStatus(dormList);
                break;
            case "maxBed":
                statistics = statisticsByMaxBed(dormList);
                break;
            default:
                result.put("success", false);
                result.put("message", "不支持的数据类型");
                return result;
        }

        // 检查数据是否足够
        if (statistics.isEmpty()) {
            result.put("success", false);
            result.put("message", "数据不足，无法绘制图像");
            return result;
        }

        // 根据图表类型构建返回数据
        result.put("success", true);
        result.put("dataType", dataType);
        result.put("chartType", chartType);
        result.put("dataTypeName", DORM_DATA_TYPE_MAP.get(dataType));
        
        if ("pie".equals(chartType)) {
            buildPieChartData(result, statistics);
        } else if ("bar".equals(chartType)) {
            buildBarChartData(result, statistics);
        }
        
        return result;
    }

    @Override
    public Map<String, String> getAvailableDormDataTypes() {
        return DORM_DATA_TYPE_MAP;
    }

    @Override
    public Map<String, Object> getStallChartData(String dataType, String chartType) {
        Map<String, Object> result = new HashMap<>();
        
        // 获取所有食堂档口数据
        List<CanteenStall> stallList = canteenStallMapper.selectCanteenStallList(new CanteenStall());
        
        if (stallList == null || stallList.isEmpty()) {
            result.put("success", false);
            result.put("message", "数据不足，无法绘制图像");
            return result;
        }

        // 根据数据类型进行统计
        Map<String, Long> statistics = new LinkedHashMap<>();
        
        switch (dataType) {
            case "canteenName":
                statistics = statisticsByCanteenName(stallList);
                break;
            case "hygieneStatus":
                statistics = statisticsByHygieneStatus(stallList);
                break;
            case "manager":
                statistics = statisticsByManager(stallList);
                break;
            case "checkPeople":
                statistics = statisticsByCheckPeople(stallList);
                break;
            default:
                result.put("success", false);
                result.put("message", "不支持的数据类型");
                return result;
        }

        // 检查数据是否足够
        if (statistics.isEmpty()) {
            result.put("success", false);
            result.put("message", "数据不足，无法绘制图像");
            return result;
        }

        // 根据图表类型构建返回数据
        result.put("success", true);
        result.put("dataType", dataType);
        result.put("chartType", chartType);
        result.put("dataTypeName", STALL_DATA_TYPE_MAP.get(dataType));
        
        if ("pie".equals(chartType)) {
            buildPieChartData(result, statistics);
        } else if ("bar".equals(chartType)) {
            buildBarChartData(result, statistics);
        }
        
        return result;
    }

    @Override
    public Map<String, String> getAvailableStallDataTypes() {
        return STALL_DATA_TYPE_MAP;
    }

    // ==================== 学生统计方法 ====================

    /**
     * 按性别统计
     */
    private Map<String, Long> statisticsByGender(List<Student> students) {
        return students.stream()
                .filter(s -> s.getGender() != null && !s.getGender().isEmpty())
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
    }

    /**
     * 按出生日期统计（按年份分组）
     */
    private Map<String, Long> statisticsByBirthDate(List<Student> students) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return students.stream()
                .filter(s -> s.getBirthDate() != null)
                .map(s -> {
                    LocalDate date = s.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    return date.format(formatter);
                })
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    /**
     * 按民族统计
     */
    private Map<String, Long> statisticsByEthnic(List<Student> students) {
        return students.stream()
                .filter(s -> s.getEthnic() != null && !s.getEthnic().isEmpty())
                .collect(Collectors.groupingBy(Student::getEthnic, Collectors.counting()));
    }

    /**
     * 按政治面貌统计
     */
    private Map<String, Long> statisticsByPolitical(List<Student> students) {
        return students.stream()
                .filter(s -> s.getPolitical() != null && !s.getPolitical().isEmpty())
                .collect(Collectors.groupingBy(Student::getPolitical, Collectors.counting()));
    }

    /**
     * 按血型统计
     */
    private Map<String, Long> statisticsByBloodType(List<Student> students) {
        return students.stream()
                .filter(s -> s.getBloodType() != null && !s.getBloodType().isEmpty())
                .collect(Collectors.groupingBy(Student::getBloodType, Collectors.counting()));
    }

    // ==================== 教职工统计方法 ====================

    /**
     * 按人员类型统计
     */
    private Map<String, Long> statisticsByStaffType(List<StaffInfo> staffList) {
        return staffList.stream()
                .filter(s -> s.getStaffType() != null && !s.getStaffType().isEmpty())
                .collect(Collectors.groupingBy(StaffInfo::getStaffType, Collectors.counting()));
    }

    /**
     * 按所属部门统计
     */
    private Map<String, Long> statisticsByDepartment(List<StaffInfo> staffList) {
        return staffList.stream()
                .filter(s -> s.getDepartment() != null && !s.getDepartment().isEmpty())
                .collect(Collectors.groupingBy(StaffInfo::getDepartment, Collectors.counting()));
    }

    /**
     * 按职称统计
     */
    private Map<String, Long> statisticsByJobTitle(List<StaffInfo> staffList) {
        return staffList.stream()
                .filter(s -> s.getJobTitle() != null && !s.getJobTitle().isEmpty())
                .collect(Collectors.groupingBy(StaffInfo::getJobTitle, Collectors.counting()));
    }

    /**
     * 按学历统计
     */
    private Map<String, Long> statisticsByEducation(List<StaffInfo> staffList) {
        return staffList.stream()
                .filter(s -> s.getEducation() != null && !s.getEducation().isEmpty())
                .collect(Collectors.groupingBy(StaffInfo::getEducation, Collectors.counting()));
    }

    /**
     * 按合同类型统计
     */
    private Map<String, Long> statisticsByContractType(List<StaffInfo> staffList) {
        return staffList.stream()
                .filter(s -> s.getContractType() != null && !s.getContractType().isEmpty())
                .collect(Collectors.groupingBy(StaffInfo::getContractType, Collectors.counting()));
    }

    /**
     * 按在职状态统计
     */
    private Map<String, Long> statisticsByStaffStatus(List<StaffInfo> staffList) {
        return staffList.stream()
                .filter(s -> s.getStaffStatus() != null && !s.getStaffStatus().isEmpty())
                .collect(Collectors.groupingBy(StaffInfo::getStaffStatus, Collectors.counting()));
    }

    // ==================== 宿舍统计方法 ====================

    /**
     * 按宿舍类型统计
     */
    private Map<String, Long> statisticsByDormType(List<DormDormitory> dormList) {
        return dormList.stream()
                .filter(d -> d.getDormType() != null && !d.getDormType().isEmpty())
                .collect(Collectors.groupingBy(DormDormitory::getDormType, Collectors.counting()));
    }

    /**
     * 按楼栋名称统计
     */
    private Map<String, Long> statisticsByBuilding(List<DormDormitory> dormList) {
        return dormList.stream()
                .filter(d -> d.getBuildingName() != null && !d.getBuildingName().isEmpty())
                .collect(Collectors.groupingBy(DormDormitory::getBuildingName, Collectors.counting()));
    }

    /**
     * 按楼层统计
     */
    private Map<String, Long> statisticsByFloorNum(List<DormDormitory> dormList) {
        return dormList.stream()
                .filter(d -> d.getFloorNum() != null)
                .collect(Collectors.groupingBy(d -> String.valueOf(d.getFloorNum()), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    /**
     * 按卫生评级统计
     */
    private Map<String, Long> statisticsByDormHygiene(List<DormDormitory> dormList) {
        return dormList.stream()
                .filter(d -> d.getDormHygiene() != null && !d.getDormHygiene().isEmpty())
                .collect(Collectors.groupingBy(DormDormitory::getDormHygiene, Collectors.counting()));
    }

    /**
     * 按查寝状态统计
     */
    private Map<String, Long> statisticsByDormCheckStatus(List<DormDormitory> dormList) {
        return dormList.stream()
                .filter(d -> d.getDormCheckStatus() != null && !d.getDormCheckStatus().isEmpty())
                .collect(Collectors.groupingBy(DormDormitory::getDormCheckStatus, Collectors.counting()));
    }

    /**
     * 按床位数量统计
     */
    private Map<String, Long> statisticsByMaxBed(List<DormDormitory> dormList) {
        return dormList.stream()
                .filter(d -> d.getMaxBed() != null)
                .collect(Collectors.groupingBy(d -> String.valueOf(d.getMaxBed()), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // ==================== 食堂档口统计方法 ====================

    /**
     * 按所属食堂统计
     */
    private Map<String, Long> statisticsByCanteenName(List<CanteenStall> stallList) {
        return stallList.stream()
                .filter(s -> s.getCanteenName() != null && !s.getCanteenName().isEmpty())
                .collect(Collectors.groupingBy(CanteenStall::getCanteenName, Collectors.counting()));
    }

    /**
     * 按卫生检查结果统计
     */
    private Map<String, Long> statisticsByHygieneStatus(List<CanteenStall> stallList) {
        return stallList.stream()
                .filter(s -> s.getHygieneStatus() != null && !s.getHygieneStatus().isEmpty())
                .collect(Collectors.groupingBy(CanteenStall::getHygieneStatus, Collectors.counting()));
    }

    /**
     * 按档口负责人统计
     */
    private Map<String, Long> statisticsByManager(List<CanteenStall> stallList) {
        return stallList.stream()
                .filter(s -> s.getManager() != null && !s.getManager().isEmpty())
                .collect(Collectors.groupingBy(CanteenStall::getManager, Collectors.counting()));
    }

    /**
     * 按检查人统计
     */
    private Map<String, Long> statisticsByCheckPeople(List<CanteenStall> stallList) {
        return stallList.stream()
                .filter(s -> s.getCheckPeople() != null && !s.getCheckPeople().isEmpty())
                .collect(Collectors.groupingBy(CanteenStall::getCheckPeople, Collectors.counting()));
    }

    // ==================== 图表数据构建方法 ====================

    /**
     * 构建饼图数据
     */
    private void buildPieChartData(Map<String, Object> result, Map<String, Long> statistics) {
        List<Map<String, Object>> pieData = new ArrayList<>();
        
        for (Map.Entry<String, Long> entry : statistics.entrySet()) {
            Map<String, Object> item = new HashMap<>();
            item.put("name", entry.getKey());
            item.put("value", entry.getValue());
            pieData.add(item);
        }
        
        result.put("series", pieData);
        result.put("labels", new ArrayList<>(statistics.keySet()));
        result.put("values", new ArrayList<>(statistics.values()));
    }

    /**
     * 构建柱状图数据
     */
    private void buildBarChartData(Map<String, Object> result, Map<String, Long> statistics) {
        result.put("labels", new ArrayList<>(statistics.keySet()));
        result.put("values", new ArrayList<>(statistics.values()));
    }
}
