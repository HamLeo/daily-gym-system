package com.lzh.service.impl;

import com.lzh.mapper.EquipmentMapper;
import com.lzh.pojo.Equipment;
import com.lzh.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaTianQi [1113184796@qq.com]
 * @date 2022/3/22
 */

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> findAll() {
        return equipmentMapper.findAll();
    }

    @Override
    public Boolean deleteByEquipmentId(Integer equipmentId) {
        return equipmentMapper.deleteByEquipmentId(equipmentId);
    }

    @Override
    public Boolean insertEquipment(Equipment equipment) {
        return equipmentMapper.insertEquipment(equipment);
    }

    @Override
    public Boolean updateEquipmentByEquipmentId(Equipment equipment) {
        return equipmentMapper.updateEquipmentByEquipmentId(equipment);
    }

    @Override
    public List<Equipment> selectByEquipmentId(Integer equipmentId) {
        return equipmentMapper.selectByEquipmentId(equipmentId);
    }

    @Override
    public Integer selectTotalCount() {
        return equipmentMapper.selectTotalCount();
    }
}
