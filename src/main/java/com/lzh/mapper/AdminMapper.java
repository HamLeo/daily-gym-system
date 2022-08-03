package com.lzh.mapper;

import com.lzh.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

@Mapper
public interface AdminMapper {

    Admin selectByAccountAndPassword(Admin admin);

}
