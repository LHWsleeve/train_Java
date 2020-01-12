package com.guigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorTestController {

    @RequestMapping("/test01")
    public String test01(){
        System.out.format("01拦截器被调用\n");

        return "success";
    }


}
