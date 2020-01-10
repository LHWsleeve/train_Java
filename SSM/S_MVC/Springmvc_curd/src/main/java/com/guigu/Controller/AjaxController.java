package com.guigu.Controller;

import com.guigu.dao.EmployeeDao;
import com.guigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class AjaxController {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * 将返回的数据放在响应体中
     * 如果是对象，自动将对象转为json(jackson包做的)
     * 注意：spring4.0以上版本要用jackson2.6以上版本
     * @return
     */
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll(){
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }
}
