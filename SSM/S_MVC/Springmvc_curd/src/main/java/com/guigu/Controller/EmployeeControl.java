package com.guigu.Controller;

import com.guigu.dao.EmployeeDao;
import com.guigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeControl {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * 查询所有员工
     */
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }


}
