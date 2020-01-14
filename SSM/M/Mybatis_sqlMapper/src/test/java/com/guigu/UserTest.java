package com.guigu;


import com.guigu.bean.Employee;
import com.guigu.bean.User;
import com.guigu.dao.EmployeeDao;
import com.guigu.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {

    SqlSessionFactory sqlSessionFactory;

    @Before//这个注解表示每次test运行之前，这个方法先运行
    public void init() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 默认 mybatis自动封装结果集
     *      1）、按照列名和属性名一一对应的规则（不区分大小写）
     *      2）、如果不一一对应；
     *          1）、开启驼峰命名法（满足驼峰命名规则 aaa_bbb aaaBbb）
     *          2）、起别名
     *
     */
    @Test
    public void test01() {
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            UserDao openSessionMapper = openSession.getMapper(UserDao.class);
            User user = openSessionMapper.getUserById(1);
            System.out.println("查找成功：" + user);
        } finally {
            openSession.commit();
            openSession.close();
        }
    }
}
