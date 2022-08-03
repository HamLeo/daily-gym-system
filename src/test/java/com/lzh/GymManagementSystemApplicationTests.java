package com.lzh;

import com.lzh.mapper.MemberMapper;
import com.lzh.pojo.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

@SpringBootTest
class GymManagementSystemApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MemberMapper memberMapper;


    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from admin", Long.class);
        System.out.println("记录总数" + aLong);
    }

    @Test
    public void run() throws Exception {
        List<Member> list = memberMapper.findAll();
        for (Member member : list) {
            System.out.println(member);
        }

        Integer total = memberMapper.selectTotalCount();
        System.out.println(total);
    }


}
