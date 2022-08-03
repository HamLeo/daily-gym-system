package com.lzh.service.impl;

import com.lzh.mapper.AdminMapper;
import com.lzh.pojo.Admin;
import com.lzh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiaTianQi [1113184796@qq.com]
 * @date 2022/3/22
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin adminLogin(Admin admin) {
        return adminMapper.selectByAccountAndPassword(admin);
    }
}
