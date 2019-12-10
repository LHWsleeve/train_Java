package com.guigu.spring.service;

import com.guigu.spring.bean.User;
import com.guigu.spring.dao.BaseDao;
import com.guigu.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

}
