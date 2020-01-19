package com.guigu.contorller;

import com.guigu.bean.Teacher;
import com.guigu.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @RequestMapping("/getTeacher")
    public String getTeacher(@RequestParam(value = "id")Integer id, Model model){
       Teacher teacher =  teacherService.getTeacher(id);
       model.addAttribute("teacher",teacher);
        return "success";
    }
}
