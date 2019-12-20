package com.guigu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String handle01(){
        System.out.println("hello。。。");
        return "success";
    }
}
