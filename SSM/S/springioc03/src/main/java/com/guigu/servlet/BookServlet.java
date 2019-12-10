package com.guigu.servlet;

import com.guigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring通过Autowired注解技术，属性自动赋值，自动装配
 */
@Controller
public class BookServlet{
//@Qualifier:指定一个名作为id，让Spring使用指定名.并且指定名必须是已有JavaBean的名。
//    @Qualifier("bookEXT")
    @Autowired//若在方法上使用Autowired注解，则该方法内的对象的引用都会自动装配
    private BookService bookService;

    public void Do(){
        bookService.save();
    }
}
