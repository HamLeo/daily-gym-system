package com.lzh.mapper;

import com.lzh.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LiuZhiHan [985936872@qq.com]
 * @date 2022/3/22
 */

@Mapper
public interface EmployeeMapper {

    //查询所有员工
    List<Employee> findAll();

    //根据员工账号删除员工
    Boolean deleteByEmployeeAccount(Integer employeeAccount);

    //添加新员工
    Boolean insertEmployee(Employee employee);

    //根据员工账号修改会员信息
    Boolean updateMemberByEmployeeAccount(Employee employee);

    //根据员工账号查询员工
    List<Employee> selectByEmployeeAccount(Integer employeeAccount);

    //查询员工数
    Integer selectTotalCount();

}
