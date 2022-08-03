package com.lzh.service.impl;

import com.lzh.mapper.ClassTableMapper;
import com.lzh.pojo.ClassTable;
import com.lzh.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaTianQi [1113184796@qq.com]
 * @date 2022/3/22
 */

@Service
public class ClassTableServiceImpl implements ClassTableService {

    @Autowired
    private ClassTableMapper classTableMapper;

    @Override
    public List<ClassTable> findAll() {
        return classTableMapper.findAll();
    }

    @Override
    public Boolean deleteClassByClassId(Integer classId) {
        return classTableMapper.deleteClassByClassId(classId);
    }

    @Override
    public Boolean insertClass(ClassTable classTable) {
        return classTableMapper.insertClass(classTable);
    }

    @Override
    public ClassTable selectByClassId(Integer classId) {
        return classTableMapper.selectByClassId(classId);
    }

    @Override
    public Boolean deleteOrderByClassId(Integer classId) {
        return classTableMapper.deleteOrderByClassId(classId);
    }

    @Override
    public List<ClassTable> selectByCoachId(Integer coachId) {
        return classTableMapper.selectByCoachId(coachId);
    }
}
