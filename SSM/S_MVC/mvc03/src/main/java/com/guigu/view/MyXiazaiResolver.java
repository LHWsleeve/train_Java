package com.guigu.view;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;


public class MyXiazaiResolver implements ViewResolver, Ordered {

    private int order;
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {

        //根据视图名，返回视图对象
        if (s.startsWith("xiazai:")){
            return new MyView();
        }else {
            //如果不能处理，返回null
            return null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int getOrder() {
        return order;
    }
    //改变视图解析器的优先级
    public void setOrder(Integer order){

        this.order=order;
    }
}
