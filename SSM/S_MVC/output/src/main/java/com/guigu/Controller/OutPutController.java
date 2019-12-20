package com.guigu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * SpringMVC除了在方法上传入原生的requset和session外，还呢个怎么样将数据带到页面
 * 1.可以在方法传入Map/Modle/ModelMap。这些参数里面保存的所有数据都会放在域中，可以在页面获取
 * 第一种三个方法都放在请求域中
 *
 *
 */
@Controller
public class OutPutController {

    @RequestMapping("/handle01")
    public String handle01(Map<String,Object> map){
        map.put("msg","你好");
        return "success";
    }

    /**
     * Modle：一个接口
     * @param model
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(Model model){
        model.addAttribute("msg","model你好");
        return "success";
    }


    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap){
        modelMap.addAttribute("msg","modelMap你好");
        return "success";
    }
}
