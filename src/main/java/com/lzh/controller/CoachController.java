package com.lzh.controller;

import com.lzh.pojo.ClassOrder;
import com.lzh.pojo.ClassTable;
import com.lzh.pojo.Coach;
import com.lzh.service.ClassOrderService;
import com.lzh.service.ClassTableService;
import com.lzh.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */
@Controller
@RequestMapping("/coach")
public class CoachController
{
    @Autowired
    private CoachService coachService;

    @Autowired
    private ClassOrderService classOrderService;

    @Autowired
    private ClassTableService classTableService;

    //查询教练
    @RequestMapping("/selCoach")
    public String selectCoach(Model model) {
        List<Coach> coachList = coachService.findAll();
        model.addAttribute("coachList", coachList);
        return "selectCoach";
    }

    //跳转新增教练页面
    @RequestMapping("/toAddCoach")
    public String toAddCoach() {
        return "addCoach";
    }

    //新增教练
    @RequestMapping("/addCoach")
    public String addCoach(Coach coach) {
        //教练教练号随机生成
        Random random = new Random();
        String account1 = "2021";
        for (int i = 0; i < 5; i++) {
            account1 += random.nextInt(10);
        }
        Integer account = Integer.parseInt(account1);

        //初始密码
        String password = "123456";
        coach.setCoachID(account);
        coach.setCoachPassword(password);
        coachService.insertCoach(coach);
        return "redirect:selCoach";
    }

    //删除教练
    @RequestMapping("/delCoach")
    public String deleteCoach(Integer coachID) {
       coachService.deleteBycoachID(coachID);
        return "redirect:selCoach";
    }

    //跳转教练修改页面
    @RequestMapping("/toUpdateCoachInfo")
    public String toUpdateMember(HttpSession session, Model model) {
        Coach coach = (Coach) session.getAttribute("coach");
        model.addAttribute("coach", coach);
        return "updateCoachInformation";
    }

    //修改教练信息
    @RequestMapping("/updateCoach")
    public String updateCoach(HttpSession session, Coach coach) {
        Coach coach1 = (Coach) session.getAttribute("coach");

        coach.setCoachName(coach1.getCoachName());
        coach.setCoachPassword(coach1.getCoachPassword());
        coach.setCoachGender(coach1.getCoachGender());
        coach.setCoachAge(coach1.getCoachAge());
        coach.setCoachnumber(coach1.getCoachnumber());
        coach.setCoachphone(coach1.getCoachphone());
        coach.setCoachsalary(coach1.getCoachsalary());

        coachService.updateCoachBycoachID(coach);
        return "coachInformation";
    }

//    //跳转教练查询页面
//    @RequestMapping("/toSelByCard")
//    public String toSelectByCardId() {
//        return "selectBycoachID";
//    }

    //根据教练号查询
//    @RequestMapping("/selByCard")
//    public String selectByCardId(Model model, Integer coachID)
//    {
//        List<Coach> coachList = coachService.selectBycoachID(coachID);
//        if (coachList != null)
//        {
//            model.addAttribute("coachList", coachList);
//        } else {
//            String message = "教练号不存在！";
//            model.addAttribute("noMessage", message);
//        }
//        return "selectBycoachID";
//    }

    //跳转教练个人信息界面
    @RequestMapping("/toCoachInfo")
    public String toCoachInformation(Model model, HttpSession session){
        Coach coach = (Coach) session.getAttribute("coach");
        model.addAttribute("coach",coach);

        System.out.println(coach.getCoachGender()+" "+coach.getCoachName());
        return "coachInformation";
    }


    //根据教练ID查询学员上课信息
    @RequestMapping("toSelMemberByCoachId")
    public String toSelMemberByCoachId(Model model,HttpSession session){
        Coach coach = (Coach) session.getAttribute("coach");
        model.addAttribute("coach",coach);
        Integer coachID = coach.getCoachID();
        List<ClassOrder> classOrderList = classOrderService.selectMemberByCoachId(coachID);
        model.addAttribute("classOrderList",classOrderList);
        return "selMemberByCoachId";
    }

    //根据教练ID查询课程安排
    @RequestMapping("toSelClassByCoachId")
    public String toSelClassByCoachId(Model model,HttpSession session){
        Coach coach = (Coach) session.getAttribute("coach");
        Integer coachID = coach.getCoachID();
        List<ClassTable> classList = classTableService.selectByCoachId(coachID);
        model.addAttribute("classList",classList);
        return "selClassByCoachId";
    }
}
