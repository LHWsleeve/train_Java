package com.guigu.dao;

import com.guigu.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

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

    //返回map.列名作为key，值作为vaue
    public Map<String,Object> getEmployeeByidmap(Integer id);

    //返回多条记录，key就是这个记录的主键；Va1ue就是这条记录封装好的对象；
    @MapKey("id")//把查询的记录的id的值作为key封装这个map
    public Map<Integer,Employee> getALLemp();


}
