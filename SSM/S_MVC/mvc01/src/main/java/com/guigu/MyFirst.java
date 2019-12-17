package com.guigu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1.告诉SpringMVC这是一个处理器，可以处理请求
 *  @Controller：标识那个是组件控制器
 */
@Controller
public class MyFirst {
    /**
     * 代表从当前项目下开始：处理项目下的hello请求
     * 细节：
     *      1.运行流程：
     *            1）。客户端点击链接会发送hello请求。http://localhost:10000/mvc/hello
     *            2）；来到tomcat服务器
     *            3）；springmvc的前端控制器收到所有请求
     *            4）；来看请求地址和@RequestMapping标注的那个匹配，找到对应类的方法
     *            5）；前端控制器找到了目标处理器类和方法，直接利用反射执行目标方法
     *            6）方法执行完成之后会有返回值；SpringMVC认为这个返回值就是要去的页面地址
     *            7）；拿到方法返回值以后，用视图解析器进行拼串得到完整的页面地址
     *            8）；拿到页面地址，前端控制器帮我们转发到页面
     *      2.@RequestMapping：
     *            1）；就是告诉SpringMVC这个方法用来处理什么请求
     *            2）；“/”可以省略，默认在当前项目下开始
     *      3. 如果不指定配置文件位置
     *              /WEB-INF/springDispatcherServlet-servlet.xml
     *              如果不指定也会默认去找一个文件
     *              /WEB-INF/xxx-servlet.xml,xxx=前端控制器名
     * @return
     */
    @RequestMapping("/hello")
    public String myfirst(){
        System.out.println("请求成功，正在处理");

//        视图解析器自动拼串返回一个jsp
//        <property name="prefix" value="/WEB-INF/page/"></property>
//        <property name="suffix" value=".jsp"></property>
        return "success";
    }
}
