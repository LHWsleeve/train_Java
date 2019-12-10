package com.guigu.servlet;

import com.guigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
@WebServlet(name = "BookServlet")
public class BookServlet extends HttpServlet {
    @Autowired
    private BookService bookService;

    public void Do(){
        bookService.save();
    }
}
