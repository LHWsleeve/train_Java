package com.guigu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义视图解析器和视图对象
 */
@Controller
public class MyViewResovlerController {

    @RequestMapping("/handleplus")
    public String handleplus(Model model){
        List<String > vname = new ArrayList<>();
        List<String > imgname = new ArrayList<>();
        vname.add("aaa");
        vname.add("bbb");
        imgname.add("tututu");

        model.addAttribute("video",vname);
        model.addAttribute("imgs",imgname);


        //自定义一个解析器前缀，如果有该前缀就返回下载页面
        return "xiazai:/xiazai";
    }


}
