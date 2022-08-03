package com.lzh.controller;

import com.lzh.pojo.ClassOrder;
import com.lzh.pojo.ClassTable;
import com.lzh.pojo.Member;
import com.lzh.service.ClassOrderService;
import com.lzh.service.ClassTableService;
import com.lzh.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ClassOrderService classOrderService;


    //跳转个人信息页面
    @RequestMapping("/toUserInfo")
    public String toUserInformation(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userInformation";
    }

    //跳转修改个人信息页面
    @RequestMapping("/toUpdateInfo")
    public String toUpdateUserInformation(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "updateUserInformation";
    }

    //修改个人信息
    @RequestMapping("/updateInfo")
    public String updateUserInformation(HttpSession session, Member member) {
        Member member1 = (Member) session.getAttribute("user");

        member.setMemberAccount(member1.getMemberAccount());
        member.setCardClass(member1.getCardClass());
        member.setCardTime(member1.getCardTime());
        member.setCardNextClass(member1.getCardNextClass());

        memberService.updateMemberByMemberAccount(member);
        return "userInformation";
    }

    //跳转我的课程页面
    @RequestMapping("/toUserClass")
    public String toUserClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        Integer memberAccount = member.getMemberAccount();
        List<ClassOrder> classOrderList = classOrderService.selectClassOrderByMemberAccount(memberAccount);
        model.addAttribute("classOrderList", classOrderList);
        return "userClass";
    }

    //退课
    @RequestMapping("delUserClass")
    public String deleteUserClass(Integer classOrderId) {
        classOrderService.deleteByClassOrderId(classOrderId);
        return "redirect:toUserClass";
    }

    //跳转报名选课页面
    @RequestMapping("/toApplyClass")
    public String toUserApplyClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        List<ClassTable> classList = classTableService.findAll();
        model.addAttribute("member", member);
        model.addAttribute("classList", classList);
        return "userApplyClass";
    }

    //报名选课
    @RequestMapping("/applyClass")
    public String userApplyClass(Integer classId, Model model, HttpSession session) {
        ClassTable classTable = classTableService.selectByClassId(classId);
        Member member = (Member) session.getAttribute("user");

        Integer classId1 = classTable.getClassId();
        String className = classTable.getClassName();
        String coach = classTable.getCoach();
        String classBegin = classTable.getClassBegin();
        Integer coachId = classTable.getCoachId();
        String memberName = member.getMemberName();
        Integer memberAccount = member.getMemberAccount();

        ClassOrder classOrder = new ClassOrder(classId1, className, coach, memberName, memberAccount, classBegin, coachId);
        Integer memberAccount1 = member.getMemberAccount();
        ClassOrder classOrder1 = classOrderService.selectMemberByClassIdAndMemberAccount(classId1, memberAccount1);

        //判断学员是否报名课程,如果没有则添加相对应的报名信息
        if (classOrder1 == null) {
            classOrderService.insertClassOrder(classOrder);
        }

        return "redirect:toUserClass";
    }

}
