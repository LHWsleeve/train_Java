package com.sxt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器的使用：
 * 作用：
 *  对服务器接收的请求资源和响应给浏览器资源进行管理
 *  保护servlet
 *  使用：
 *  创建了一个实现Fliter接口的java类
 *  重写方法：init，dofFilter，destory
 *  在web.xml中配置过滤器
 */
@WebFilter(filterName = "MyFilter",urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init初始化了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter执行");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);//放行。另外不论放不放行仍执行之后的过滤器语句
        System.out.println("doFilter执行222");

    }

    @Override
    public void destroy() {
        System.out.println("destory销毁了");

    }
}
