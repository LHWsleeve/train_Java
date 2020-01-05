package com.guigu.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("handle01成功");
        return "success";
    }

}
