package com.lzh.service;

import com.lzh.pojo.ClassTable;

import java.util.List;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

public interface ClassTableService {

    //查询所有课程
    List<ClassTable> findAll();

    //根据id删除课程
    Boolean deleteClassByClassId(Integer classId);

    //添加课程
    Boolean insertClass(ClassTable classTable);

    //根据id查询课表
    ClassTable selectByClassId(Integer classId);

    //根据id删除已预约的课程
    Boolean deleteOrderByClassId(Integer classId);

    //根据教练id查询所对应的课程安排
    List<ClassTable>  selectByCoachId(Integer coachId);

}
