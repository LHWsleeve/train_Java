package com.guigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试requestmapping的模糊匹配功能
 * URL地址可以写模糊的通配符
 *      ：？，替代任意一个字符
 *      *，替代任意多个字符和！一层！路径
 *      **，替代多层路径
 */
@Controller
public class RequestMappingTest {
    @RequestMapping("/ant01")
    public String antTest01(){
        System.out.println("ant01成功");
        return "success";
    }

    /**
     * ?匹配有且仅有一个字符
     * @return
     */
    @RequestMapping("/ant0?")
    public String antTest02(){
        System.out.println("ant02成功");
        return "success";
    }

    /**
     * /user/admin /user/xxx:假设user下的名是动态的
     * 路径上可以有占位符：在任意路径的地方写一个{变量名}
     * 我们可以拿到路径上某一处的占位符
     * @return
     */
    @RequestMapping("/user/{id}")
    public String pathVairable(@PathVariable("id") String id){
        System.out.println("动态路径测试,路径上的占位符："+id);
        return "success";
    }


}
