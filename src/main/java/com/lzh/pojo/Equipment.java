package com.lzh.pojo;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */
public class Equipment {

    private Integer equipmentId;
    private String equipmentName;
    private String equipmentTime;
    private Float equipmentCost;

    public Equipment() {
    }

    public Equipment(Integer equipmentId,String equipmentName,String equipmentTime,Float equipmentCost){
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentTime = equipmentTime;
        this.equipmentCost = equipmentCost;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentTime() {
        return equipmentTime;
    }

    public void setEquipmentTime(String equipmentTime) {
        this.equipmentTime = equipmentTime;
    }

    public Float getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(Float equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentTime=" + equipmentTime +
                ", equipmentCost=" + equipmentCost +
                '}';
    }
}
