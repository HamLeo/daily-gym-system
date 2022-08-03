package com.lzh.service.impl;

import com.lzh.mapper.ClassOrderMapper;
import com.lzh.pojo.ClassOrder;
import com.lzh.service.ClassOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaTianQi [1113184796@qq.com]
 * @date 2022/3/22
 */

@Service
public class ClassOrderServiceImpl implements ClassOrderService {

    @Autowired
    private ClassOrderMapper classOrderMapper;

    @Override
    public List<ClassOrder> findAll() {
        return classOrderMapper.findAll();
    }

    @Override
    public Boolean insertClassOrder(ClassOrder classOrder) {
        return classOrderMapper.insertClassOrder(classOrder);
    }

    @Override
    public List<ClassOrder> selectClassOrderByMemberAccount(Integer memberAccount) {
        return classOrderMapper.selectClassOrderByMemberAccount(memberAccount);
    }

    @Override
    public Boolean deleteByClassOrderId(Integer classOrderId) {
        return classOrderMapper.deleteByClassOrderId(classOrderId);
    }

    @Override
    public ClassOrder selectMemberByClassIdAndMemberAccount(Integer classId, Integer memberAccount) {
        return classOrderMapper.selectMemberByClassIdAndMemberAccount(classId, memberAccount);
    }

    @Override
    public List<ClassOrder> selectMemberOrderList(Integer classId) {
        return classOrderMapper.selectMemberOrderList(classId);
    }

    @Override
    public List<ClassOrder> selectMemberByCoachId(Integer coachId) {
        return classOrderMapper.selectMemberByCoachId(coachId);
    }
}
