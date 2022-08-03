package com.lzh.service;

import com.lzh.pojo.Coach;
import java.util.List;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

public interface CoachService {


    //查询教练信息
    List<Coach> findAll();

    //新增教练信息
    Boolean insertCoach(Coach coach);

    //根据教练账号修改教练信息
    Boolean updateCoachBycoachID(Coach coach);

    //查询教练账号密码（登录）
    Coach coachLogin(Coach coach);
    //Member selectBycoachIDAndPassword(Coach coach);
    //根据教练账号删除教练信息
    Boolean deleteBycoachID(Integer coachID);

    //查询教练数
    Integer selectTotalCount();

    //根据教练账号查询教练
    List<Coach> selectBycoachID(Integer coachID);
    //教练登录
    //Coach coachLogin(Coach coach);
}
