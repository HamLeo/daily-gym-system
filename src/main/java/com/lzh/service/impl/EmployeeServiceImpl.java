package com.lzh.service.impl;

import com.lzh.mapper.EmployeeMapper;
import com.lzh.pojo.Employee;
import com.lzh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaTianQi [1113184796@qq.com]
 * @date 2022/3/22
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public Boolean deleteByEmployeeAccount(Integer employeeAccount) {
        return employeeMapper.deleteByEmployeeAccount(employeeAccount);
    }

    @Override
    public Boolean insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public Boolean updateMemberByEmployeeAccount(Employee employee) {
        return employeeMapper.updateMemberByEmployeeAccount(employee);
    }

    @Override
    public List<Employee> selectByEmployeeAccount(Integer employeeAccount) {
        return employeeMapper.selectByEmployeeAccount(employeeAccount);
    }

    @Override
    public Integer selectTotalCount() {
        return employeeMapper.selectTotalCount();
    }
}
