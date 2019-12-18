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
     * params:规定请求参数.支持简单的表达式（字符串数组）
     *                      {"username"}:发送请求的时候必须带上一个username参数(任意)：没带404
     *                      {"！username"}:发送请求的时候禁止带username参数
     *                      甚至{"username=xxx"}也可以规定
     * headers：规定请求头,params一样能写简单的格式
     *
     * consumes:指接受内容类型是那种请求，规定请求头中的Context-Type
     * prodouces:告诉浏览器返回的内容类型是什么，给响应头中加上Content-Type
     */
    @RequestMapping(value = "/handle02",method = RequestMethod.POST)
    public String handle02(){
        System.out.println("02成功");
        return "success";
    }

    @RequestMapping(value = "/handle03",params = {"username"})
    public String handle03(){
        System.out.println("03成功");
        return "success";
    }

    /**
     * Usr-Agent:浏览器信息，让只有edge能访问，谷歌不能
     * Edge：User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18362
     * @return
     */
    @RequestMapping(value = "/handle04",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36"})
    public String handle04(){
        System.out.println("04成功");
        return "success";
    }



}
