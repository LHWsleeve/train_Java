package com.guigu.controller;

import com.guigu.book.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String handle01(){

        System.out.println("handle01...");
        return "success";
    }
    /**
     * SpringMVC何如获取请求带来的各种信息
     * @Requestparam:获取请求参数
     *  默认方式获取请求参数：直接给方法入参上写一个和请求参数相同的变量。这个变量就来接受请求参数的值
     *                      没带值：null
     *
     *  @RequestParam("user") String username/此种方式user必须带参数
     *       username=requset.getParameter("user")
     *         value：指定要获取的参数的key
     *         required：这个参数是否必须的
     *         defaultValue:如果没带值，设定默认值
     *  比较：@RequestParam(" user") /@PathVariable("user")
     *         /book.【{user}这一部分是PathVariable的值】?【user=admin（问号之后是RequestParam的值）】
     *
     * @RequestHeader： 获取请求头中某个key的值
     *     @RequestHeader("User-Agent")=request.getHeader("User-Agent")
     *     如果请求头中没有对应的值，会报错（有三个属性）
         *     value：指定要获取的参数的key
         *     required：这个参数是否必须的
         *     defaultValue:如果没带值，设定默认值
     *
     * @cookievalue：获取某个Cookie
     *     以前的操作：Cookie[] cookies=request.getcookies(),然后遍历所有cook，寻找所要的cookie
     *     同样上面三个属性。
     */
    @RequestMapping("/handle01")
    public String handle02(@RequestParam(defaultValue = "你没带",required = false,value = "user") String username
    , @RequestHeader("User-Agent") String userAgent, @CookieValue(value = "JSESSIONID",required = false)String jid){
        System.out.println("这个变量的值："+username);
        System.out.println("请求头中浏览器的信息："+userAgent);
        System.out.println("Cookie中浏览器的信息："+jid);
        return "success";
    }


    /**
     * 请求参数较多的情况下，按照上面的01方法很麻烦。
     * 如果我们的请求参数是一个POJO，SpringMVC会自动的为这个POJO进行赋值
     * 1)将POJO中的每一个属性，从request参数中尝试获取出来并封装
     * 2）.还可以级联封装--属性的属性
     * 3).提交的数据汉字有乱码：请求乱码(高版本tomcat原生调用不会出现)和响应乱码
     * 请求乱码和相应乱码都可以写一个字符过滤器解决。。并且字符编码过滤器要在所有过滤器之前
     * @return
     */
    @RequestMapping(value = "/book")
    public String addBook(Book book){

        System.out.println("我要保存的图书："+book);
        return "success";
    }

    /**
     * SpringMVC支持直接在参数上写原生API
     *      Httpservletrequest
         * Httpservletresponse
         * Httpsession
         * java security Principal
         * Locale
         * Inputstream
         * outputstream
         * Reader
         * Writer
     */
    @RequestMapping("/handle03")
    public String handle03(HttpServletRequest request, HttpSession session){
        request.setAttribute("req","我是请求");
        session.setAttribute("session","我是session中的");

        return "success";
    }



}
