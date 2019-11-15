package com.sxt.service;

import com.sxt.pojo.User;

public interface LoginService {
    //校验用户登录信息
    User checkLoginService(String uname, String ped);
//校验用户Cookie信息
    User checkLoginService(String id);
}
