package com.sxt.service.impl;

import com.sxt.dao.LoginDao;
import com.sxt.dao.imp.LoginDaoImpl;
import com.sxt.pojo.User;
import com.sxt.service.LoginService;

public class LoginSerivceImpl implements LoginService {
    //创建Dao层过度向
    LoginDao Id = new LoginDaoImpl();
    public User checkLoginService(String uname, String pwd) {
        return Id.checkLoginDao(uname,pwd);
    }

    @Override
    public User checkLoginService(String id) {
        return Id.checkIdDao(id);
    }
}
