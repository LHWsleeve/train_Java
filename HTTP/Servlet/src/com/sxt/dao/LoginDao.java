package com.sxt.dao;

import com.sxt.pojo.User;

public interface LoginDao {
    //根据用户名和密码或许信息
    User checkLoginDao(String uname, String pwd);
//根据Id获取用户信息
    User checkIdDao(String id);
}
