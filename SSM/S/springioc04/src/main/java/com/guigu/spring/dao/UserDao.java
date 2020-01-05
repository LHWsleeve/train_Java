package com.guigu.spring.dao;

import com.guigu.spring.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("保存用户.....");
    }
}