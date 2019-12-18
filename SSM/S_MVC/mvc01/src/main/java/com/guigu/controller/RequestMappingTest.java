package com.guigu.controller;

import org.springframework.stereotype.Controller;
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


}
