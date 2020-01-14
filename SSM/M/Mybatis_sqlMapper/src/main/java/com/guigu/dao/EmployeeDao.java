package com.guigu.dao;

import com.guigu.bean.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDao {

    //按照id查询员工
    public Employee getEmployeeByid(Integer id);

    public Employee getEmployeeByidAndEmp(@Param("id") Integer id,@Param("empname") String emp);

    //修改员工
    public Employee updateEmp(Employee employee);
    //删除
    public boolean deleteEmp(Integer id);
    //插入
    public int insertEmp(Employee employee);
}
