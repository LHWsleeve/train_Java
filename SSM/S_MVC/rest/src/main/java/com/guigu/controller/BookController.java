package com.guigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook(){
        System.out.println("添加了新的图书");
        return "success";
    }
//    @ResponseBody
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
    public String deletBook(@PathVariable("bid") Integer id){
        System.out.println("删除了"+id+"图书");
        return "success";
    }

//    @ResponseBody
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid") Integer id){
        System.out.println("更新了"+id+"图书");
        return "success";
    }

    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String getBook(@PathVariable("bid") Integer id){
        System.out.println("已经查询到了图书："+id);
        return "success";
    }
}
