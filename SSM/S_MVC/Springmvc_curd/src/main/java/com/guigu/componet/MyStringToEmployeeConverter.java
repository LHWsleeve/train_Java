package com.guigu.componet;

import com.guigu.dao.DepartmentDao;
import com.guigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * 自定义类型转换器
 */
public class MyStringToEmployeeConverter implements Converter {
    @Autowired
    DepartmentDao departmentDao;
    @Override
    public Object convert(Object o) {
        System.out.format("页面将要转换的"+o);
        Employee employee = new Employee();
        if (((String)o).contains("-")){
            String[] split = ((String) o).split("-");
            employee.setLastName(split[0]);
            employee.setEmail(split[1]);
            employee.setGender(Integer.parseInt(split[2]));
            employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));
        }
        return employee;
    }
}
