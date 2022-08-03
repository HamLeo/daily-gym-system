package com.lzh.service.impl;

import com.lzh.mapper.CoachMapper;
import com.lzh.pojo.Coach;
import com.lzh.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaTianQi [1113184796@qq.com]
 * @date 2022/3/22
 */

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    private CoachMapper coachMapper;
    @Override
    public List<Coach> findAll() {
        return coachMapper.findAll();
    }

    @Override
    public Boolean deleteBycoachID(Integer coachID) {
        return coachMapper.deleteBycoachID(coachID);
    }

    @Override
    public Boolean insertCoach(Coach coach) {
        return coachMapper.insertCoach(coach);
    }

    @Override
    public Boolean updateCoachBycoachID(Coach coach) {
        return coachMapper.updateCoachBycoachID(coach);
    }

    @Override
    public List<Coach> selectBycoachID(Integer coachID) {
        return coachMapper.selectBycoachID(coachID);
    }
    @Override
    public Integer selectTotalCount() {
        return coachMapper.selectTotalCount();
    }
    public Coach coachLogin(Coach coach)
    {
        return coachMapper.selectBycoachIDAndPassword(coach);
    }
}
