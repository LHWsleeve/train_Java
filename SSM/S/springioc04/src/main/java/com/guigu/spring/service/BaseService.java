package com.guigu.spring.service;

import com.guigu.spring.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 在BaseService中没有@Service,正常情况下没有这个东西，他不会被放入容器Autowired不起作用。
 * 但是在本例子中，这个基类被它的子类继承，而它的子类被放入了容器，
 * 所以实际上Autowired实在子类中实现自动装配而非基类。
 * @param <T>
 */

public class BaseService<T> {
    @Autowired
    BaseDao<T> baseDao;//注意这里一定要加入泛型<T>。
    // 没有添加泛型，以致找到的都是同一个Bean，所以需要加上泛型，或者将该BaseService类声明为抽象类。
    public void save(){
        System.out.println("自动注入的dao"+ baseDao);
        baseDao.save();
    }
}
