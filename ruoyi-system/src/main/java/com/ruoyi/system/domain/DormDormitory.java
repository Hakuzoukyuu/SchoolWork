package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍信息主对象 dorm_dormitory
 * 
 * @author ruoyi
 * @date 2026-04-28
 */
public class DormDormitory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宿舍主键ID */
    private Long dormId;

    /** 楼栋名称 */
    @Excel(name = "楼栋名称")
    private String buildingName;

    /** 宿舍编号 */
    @Excel(name = "宿舍编号")
    private String dormNo;

    /** 楼层 */
    @Excel(name = "楼层")
    private Long floorNum;

    /** 最大床位数量 */
    @Excel(name = "最大床位数量")
    private Long maxBed;

    /** 宿舍类型 */
    @Excel(name = "宿舍类型")
    private String dormType;

    /** 宿舍整体卫生评级 */
    @Excel(name = "宿舍整体卫生评级")
    private String dormHygiene;

    /** 宿舍整体查寝状态 */
    @Excel(name = "宿舍整体查寝状态")
    private String dormCheckStatus;

    /** 宿舍管理员 */
    @Excel(name = "宿舍管理员")
    private String managerName;

    /** 床位与学生入住子信息 */
    private List<DormBed> dormBedList;

    public void setDormId(Long dormId) 
    {
        this.dormId = dormId;
    }

    public Long getDormId() 
    {
        return dormId;
    }

    public void setBuildingName(String buildingName) 
    {
        this.buildingName = buildingName;
    }

    public String getBuildingName() 
    {
        return buildingName;
    }

    public void setDormNo(String dormNo) 
    {
        this.dormNo = dormNo;
    }

    public String getDormNo() 
    {
        return dormNo;
    }

    public void setFloorNum(Long floorNum) 
    {
        this.floorNum = floorNum;
    }

    public Long getFloorNum() 
    {
        return floorNum;
    }

    public void setMaxBed(Long maxBed) 
    {
        this.maxBed = maxBed;
    }

    public Long getMaxBed() 
    {
        return maxBed;
    }

    public void setDormType(String dormType) 
    {
        this.dormType = dormType;
    }

    public String getDormType() 
    {
        return dormType;
    }

    public void setDormHygiene(String dormHygiene) 
    {
        this.dormHygiene = dormHygiene;
    }

    public String getDormHygiene() 
    {
        return dormHygiene;
    }

    public void setDormCheckStatus(String dormCheckStatus) 
    {
        this.dormCheckStatus = dormCheckStatus;
    }

    public String getDormCheckStatus() 
    {
        return dormCheckStatus;
    }

    public void setManagerName(String managerName) 
    {
        this.managerName = managerName;
    }

    public String getManagerName() 
    {
        return managerName;
    }

    public List<DormBed> getDormBedList()
    {
        return dormBedList;
    }

    public void setDormBedList(List<DormBed> dormBedList)
    {
        this.dormBedList = dormBedList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dormId", getDormId())
            .append("buildingName", getBuildingName())
            .append("dormNo", getDormNo())
            .append("floorNum", getFloorNum())
            .append("maxBed", getMaxBed())
            .append("dormType", getDormType())
            .append("dormHygiene", getDormHygiene())
            .append("dormCheckStatus", getDormCheckStatus())
            .append("managerName", getManagerName())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("dormBedList", getDormBedList())
            .toString();
    }
}
