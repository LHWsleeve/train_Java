package com.guigu.view;

import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Map;

/**
 * 自定义视图
 */
public class MyView implements View {
    /**
     * 返回数据内容的类型
     * @return
     */
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("之前保存的数据："+map);
        //forceEncoding源码中只设置编码类型，
        //但是显示的文本内容格式没有设置，比如（text/html），所以在响应前先设置
        httpServletResponse.setContentType("text/html");
        List<String> vn = (List<String>) map.get("video");
        for (String s:vn){
            httpServletResponse.getWriter().write("<a>下载"+s+"</a></br>");
        }
        httpServletResponse.getWriter().println("跑通了");
    }
}
