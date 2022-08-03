package com.lzh.mapper;

import com.lzh.pojo.Coach;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */
@Mapper
public interface CoachMapper
{
    //查询所有教练
    List<Coach> findAll();
    //根据教练号查询教练
    List<Coach> selectBycoachID(Integer coachID);
    //查询教练账号密码
    Coach selectBycoachIDAndPassword(Coach coach);
    //根据教练号删除教练
    Boolean deleteBycoachID(Integer coachID);
    //添加新教练
    Boolean insertCoach(Coach coach);
    //根据教练号修改教练信息
     Boolean updateCoachBycoachID(Coach coach);
    //查询教练数
    Integer selectTotalCount();
}
