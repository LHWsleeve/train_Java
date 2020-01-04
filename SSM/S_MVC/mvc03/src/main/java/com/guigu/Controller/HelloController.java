package com.guigu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//     redirect，foward:有前缀的转发，不会有我们配置的视图解析器拼串

@Controller
public class HelloController {

    //执行hello方法后，return到hello页面。直接return，视图解析器会自动拼串导致回到/WEB-INF/page/xx,但是hello不在该文件夹下
    @RequestMapping("/hello")
    public String hello(){
        //1.使用相对路径
        return "../../hello";
    }

    /**
     * foward:转发一个页面
     * foward:前缀的转发，不会有我们配置的视图解析器拼串
     * 一定加上/，如果没有/，就是相对路径容易错误
     * /hello.jsp：转发当前项目下的hello.jsp，当前webapp下
     * @return
     */
    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("handle01");
        //2.使用forward
        return "forward:/hello.jsp";
    }
    @RequestMapping("/handle02")
    public String handle02(){
        System.out.println("handle02");
        //2.使用forward,多次派发。handle02-->handle01-->hello.jsp
        return "forward:/handle01";
    }

    /**
     * 重定向到he11o.jsp页面
     * 转发 forward：转发的路径
     * 重定向 redirect：重定向的路径。SpringMVC会为路径拼接上项目名可以直接写/hello.jsp
     * 原生Servlet重定向需要加上项目名才能重定向，下面这种方式不行
     *      response.sendRedirect("/hello.jsp")
     * @return
     */
    @RequestMapping("/handle03")
    public String handle03() {
        System.out.println("handle03");
        return "redirect:/hello.jsp";
    }

    @RequestMapping("/handle04")
    public String handle04() {
        System.out.println("handle04");
        return "redirect:/handle03";
    }
}
