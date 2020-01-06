package com.guigu.Controller;

import com.guigu.dao.DepartmentDao;
import com.guigu.dao.EmployeeDao;
import com.guigu.entities.Department;
import com.guigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeControl {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工
     */
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }
//添加员工之前，需要查询出所有部门,放在请求域中
    @RequestMapping("/toaddpage")
    public String toAddpage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        model.addAttribute("employee",new Employee());
        return "add";
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(Employee employee){
        System.out.println("要添加的员工："+employee.toString());
        employeeDao.save(employee);
        //返回列表页面,直接重定向到”查询所有员工“
        return "redirect:/emps";
    }

    /**
     * 查询员工，来到修改页面回显
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id")Integer id, Model model){
        //查出员工信息
        Employee employee = employeeDao.get(id);
        //放入隐含模型model请求域
        model.addAttribute("employee",employee);
        //查出部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "edit";
    }

    @RequestMapping(value = "emp/{id}", method = RequestMethod.PUT)
    public String updateEmp(Employee employee){
        System.out.println("要修改的员工："+employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }

@ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id",required = false)Integer id,  Model model){
        if (id!=null){
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee",employee);
        }
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@RequestParam("id")Integer id){
        employeeDao.delete(id);
        return "redirct:/emps";
    }

}
