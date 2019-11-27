package com.sxt.servlet;

import org.apache.catalina.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MYFilter",urlPatterns = "/ck")
public class MYFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("MYFilter我执行了");
        //使用过滤器判断session是否失效
      HttpSession hs = ((HttpServletRequest)req).getSession();//记住强转HttpServletRequest是ServletRequest的子类，下同
      if (hs.getAttribute("user")!=null){
          chain.doFilter(req, resp);
      }else {
          ((HttpServletResponse)resp).sendRedirect("/login/page");
      }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
