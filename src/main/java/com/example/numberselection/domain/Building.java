package com.example.numberselection.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("building")
public class Building {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer buildingNo;

    private Integer floorSum;

    private Integer area;

    private Integer unitSum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getFloorSum() {
        return floorSum;
    }

    public void setFloorSum(Integer floorSum) {
        this.floorSum = floorSum;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getUnitSum() {
        return unitSum;
    }

    public void setUnitSum(Integer unitSum) {
        this.unitSum = unitSum;
    }
}
