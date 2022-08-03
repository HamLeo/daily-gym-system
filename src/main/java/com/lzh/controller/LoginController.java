package com.lzh.controller;

import com.lzh.pojo.Admin;
import com.lzh.pojo.Coach;
import com.lzh.pojo.Member;
import com.lzh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private CoachService coachService;

    //主页、跳转管理员登录页面
    @RequestMapping("/")
    public String toAdminLogin() {
        return "adminLogin";
    }

    //跳转会员登录页面
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {
        return "userLogin";
    }

    //跳转教练登录页面
    @RequestMapping("/toCoachLogin")
    public String toCoachLogin(){
        return "coachLogin";
    }

    //管理员登录
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, Model model, HttpSession session) {
        Admin admin1 = adminService.adminLogin(admin);
        //System.out.println(admin.getAdminAccount());
        if (admin1 != null) {
            //会员人数
            Integer memberTotal = memberService.selectTotalCount();
            model.addAttribute("memberTotal", memberTotal);
            session.setAttribute("memberTotal", memberTotal);

            //员工人数
            Integer employeeTotal = employeeService.selectTotalCount();
            model.addAttribute("employeeTotal", employeeTotal);
            session.setAttribute("employeeTotal", employeeTotal);

            //健身房总人数
            Integer humanTotal = memberTotal + employeeTotal;
            model.addAttribute("humanTotal", humanTotal);
            session.setAttribute("humanTotal", humanTotal);

            //器材数
            Integer equipmentTotal = equipmentService.selectTotalCount();
            model.addAttribute("equipmentTotal", equipmentTotal);
            session.setAttribute("equipmentTotal", equipmentTotal);

            return "adminMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入!");
        return "adminLogin";
    }

    //会员登录
    @RequestMapping("/userLogin")
    public String userLogin(Member member, Model model, HttpSession session) {
        System.out.println(member.getMemberAccount()+" "+member.getMemberPassword());
        Member member1 = memberService.userLogin(member);
        if (member1 != null) {
            model.addAttribute("member", member1);
            session.setAttribute("user", member1);
            return "userMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入!");
        return "userLogin";
    }

    //教练登录
    @RequestMapping(value = "/coachLogin",method = RequestMethod.POST)
    public String coachLogin(Coach coach, Model model, HttpSession session) {
        System.out.println(coach.getCoachID()+" "+ coach.getCoachPassword());
        Coach coach1 = coachService.coachLogin(coach);
        if (coach1 != null) {
            model.addAttribute("coach", coach1);
            session.setAttribute("coach", coach1);
            return "coachMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入!");
        return "coachLogin";
    }

    //跳转管理员主页
    @RequestMapping("/toAdminMain")
    public String toAdminMain(Model model, HttpSession session) {
        Integer memberTotal = (Integer) session.getAttribute("memberTotal");
        Integer employeeTotal = (Integer) session.getAttribute("employeeTotal");
        Integer humanTotal = (Integer) session.getAttribute("humanTotal");
        Integer equipmentTotal = (Integer) session.getAttribute("equipmentTotal");
        model.addAttribute("memberTotal", memberTotal);
        model.addAttribute("employeeTotal", employeeTotal);
        model.addAttribute("humanTotal", humanTotal);
        model.addAttribute("equipmentTotal", equipmentTotal);
        return "adminMain";
    }

    //跳转会员主页
    @RequestMapping("/toUserMain")
    public String toUserMain(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userMain";
    }

    //跳转教练主页
    @RequestMapping("/toCoachMain")
    public String toCoachMain(Model model, HttpSession session) {
        Coach coach = (Coach) session.getAttribute("coach");
        model.addAttribute("coach", coach);
        return "coachMain";
    }

}
