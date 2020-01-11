package com.guigu.Controller;

import com.guigu.dao.EmployeeDao;
import com.guigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.DocFlavor;
import java.security.PublicKey;
import java.util.Collection;

@Controller
public class AjaxController {
    @Autowired
    EmployeeDao employeeDao;


    /**
     * HttpEntity<String>：比ResquestBody更强大，可以拿到所有的请求头。
     * @param str
     * @return
     */
    @RequestMapping("/test02")
    public String test01(HttpEntity<String> str){
        System.out.format("请求体："+str);
        return "success";

    }



    /**
     * 将返回的数据放在响应体中
     * 如果是对象，自动将对象转为json(jackson包做的)
     * 注意：spring4.0以上版本要用jackson2.6以上版本
     * ResponseBody返回json数据
     * RequestBody：接受json数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll(){
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }

    /**
     * RequestBody：请求体，获取请求的请求体。
     * @return
     */
    @RequestMapping("/testRequestBody1")
    public String testRequestBody(@RequestBody String body){
        System.out.format("请求体"+body);
        return "success";
    }

    @RequestMapping("/testRequestBody2")
    public String testRequestBody2(@RequestBody Employee employee){
        System.out.format("请求体"+employee);
        return "success";
    }

    /**
     *     @ResponseBody:本质的含义是将返回的数据放在响应体中。
     *     在本例中，加了该注解后，直接访问testResponseBody，把本来应该返回success页面，
     *     但是实际上是吧“success”字符串打印在页面中。
     *     不再参与视图解析器
     * @return
     */
    @RequestMapping("/testResponseBody")
//    @ResponseBody
    public ResponseEntity<String> testResponseBody(){
        System.out.format("haha");
        HttpStatus statusCode;
        String body="<h1>success<h1>";
        MultiValueMap<String, String> header = new HttpHeaders();
        header.add("Set-Cookie","username=hahahah");
        return new ResponseEntity<String>(body, header, HttpStatus.OK);
    }
}
