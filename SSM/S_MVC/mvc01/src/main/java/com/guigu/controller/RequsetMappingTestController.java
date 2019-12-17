package com.guigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * ResquestMapping的其他属性
     * method:限定请求方式
     *          GET,POST....只接收这种类型的请求，默认全接受
     *          不是规定的方式就会报错：HTTP Status 405 – Method Not Allowed
     * params:
     * headers
     * consumes:
     * prodouces:
     */
    @RequestMapping(value = "/handle02",method = RequestMethod.POST)
    public String handle02(){
        System.out.println("02成功");
        return "success";
    }

}
