package com.sxt.dao;

import com.sxt.pojo.User;

public interface LoginDao {
    User checkLoginDao(String uname, String pwd);

}
