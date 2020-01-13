package com.guigu.dao;

import com.guigu.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeDaoAnnotation {

    //按照id查询员工
    @Select({" select * from employee where id=#{id}"})
    public Employee getEmployeeByid(Integer id);
    //修改员工
    public  Employee updateEmp(Employee employee);
    //删除
    public boolean deleteEmp(Integer id);
    //插入
    public int insertEmp(Employee employee);
}
