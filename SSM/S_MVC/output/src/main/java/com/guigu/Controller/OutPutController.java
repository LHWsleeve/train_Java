package com.guigu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * SpringMVC除了在方法上传入原生的requset和session外，还呢个怎么样将数据带到页面
 * 1.可以在方法传入Map/Modle/ModelMap。这些参数里面保存的所有数据都会放在域中，可以在页面获取
 * 第一种三个方法都放在请求域中.
 * 三个方法的关系：三个方法最终都是BindingAwareModelMap在工作。实际是一个方法，
 * 相当于在BindingAwareModelMap中保存名字被放在请求域中。
 *
 *Map(interface(jdkj))     Model(interface(Spring))   ModelMap（class）
 *
 * 2.方法的返回值可以变成ModelAndView类型;
 *         集包含视图信息（页面地址）也包含模型数据（给页面带的数据）
 *         而且数据放在请求域中。(SpringMVC考虑一般数据都放在请求域中)
 *         request/session/application
 *3）给session域中带数据：SpringMVC提供了特殊方式临时给Session域中保存数据的方式
 *      使用一个注解@SessionAttributes（必须标在类上）
 *      @SessionAttributes(value = "msg"):给BindingAwareModelMap（也就是前面所有的方式）中保存了数据。同时给session中放一份msg
 *      value指定保存数据时往session中放的数据
 *      va1ue={"msg"}，只要保存的是这种key的数据，给 Session中放一份
 *      types={String.c1ass}，只要保存的是这种类型的数据，给 Sessioni中也放一份
 *
 *      但是，注解推荐使用原生API
 */


@SessionAttributes(value = "msg")
@Controller
public class OutPutController {

    @RequestMapping("/handle01")
    public String handle01(Map<String,Object> map){
        map.put("msg","你好");
        System.out.println("map类型："+ map.getClass());
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
        System.out.println("model类型："+ model.getClass());
        return "success";
    }


    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap){
        modelMap.addAttribute("msg","modelMap你好");
        System.out.println("modelMap类型："+ modelMap.getClass());
        return "success";
    }



    @RequestMapping("/handle04")
    public ModelAndView handle04(ModelMap modelMap){
        //之前的返回值就是视图名，视图解析器会拼串并得到最终地址
        ModelAndView mv = new ModelAndView("success");
        mv.addObject("msg","mv你好");

        return mv;
    }

}
