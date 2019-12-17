package com.guigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RequestMapping加载类之前，为当前类的所有方法指定一个基准方法
 */
@RequestMapping("/haha")
@Controller
public class RequsetMappingTestController {
    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("RequsetMappingTestController----handlw01--被调用了");
        return "success";
    }

}
