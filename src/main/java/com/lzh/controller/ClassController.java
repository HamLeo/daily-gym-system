package com.lzh.controller;

import com.lzh.pojo.ClassOrder;
import com.lzh.pojo.ClassTable;
import com.lzh.service.ClassOrderService;
import com.lzh.service.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private ClassOrderService classOrderService;

    //查询课程
    @RequestMapping("/selClass")
    public String selectClass(Model model) {
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("classList", classList);
        return "selectClass";
    }

    //跳转新增课程页面
    @RequestMapping("/toAddClass")
    public String toAddClass() {
        return "addClass";
    }

    //新增课程
    @RequestMapping("/addClass")
    public String addClass(ClassTable classTable) {
        classTableService.insertClass(classTable);
        return "redirect:selClass";
    }

    //删除课程
    @RequestMapping("/delClass")
    public String deleteClass(Integer classId) {
        classTableService.deleteClassByClassId(classId);
        classTableService.deleteOrderByClassId(classId);
        return "redirect:selClass";
    }

    //查询课程报名信息
    @RequestMapping("/selClassOrder")
    public String selectClassOrder(Integer classId, Model model) {
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        model.addAttribute("classOrderList", classOrderList);
        return "selectClassOrder";
    }

    //根据教练ID查询课程报名信息
    @RequestMapping("/selClassOrderByCoach")
    public String selectClassOrderByCoach(Integer classId, Model model){
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        model.addAttribute("classOrderList",classOrderList);
        return "selectClassOrderByCoachId";
    }

}
