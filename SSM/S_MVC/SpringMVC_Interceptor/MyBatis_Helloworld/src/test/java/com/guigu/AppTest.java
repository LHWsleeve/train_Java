package com.guigu;

import static org.junit.Assert.assertTrue;

import com.guigu.bean.Employee;
import com.guigu.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    SqlSessionFactory sqlSessionFactory;

    @Before//这个注解表示每次test运行之前，这个方法先运行
    public  void init() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    //测试查询
    @Test
    public void test01() throws IOException {
        //1.根据全局配置文件创建出一个SqlSessionFactory
        //SqlSessionFactory就是sqlsession工厂，负责创建该对象
        //SqlSession：sql会话（代表和数据库的一次会话)
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = null;
        try {
            //2.获取和数据库的一次会话=getConnection,拿到一次链接
            openSession = sqlSessionFactory.openSession();
            //3.使用SqlSession操作数据库
            EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
            //4.调用之前的方法
            Employee employee = employeeDao.getEmployeeByid(1);
            System.out.println(employee);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            openSession.close();
        }
    }


    //测试添加
    @Test
    public void test02() throws IOException {
        //.openSession(),true自动提交，flase手动提交
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
            int i = mapper.insertEmp(new Employee(null, "123", "@qqq", 0));
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //手动提交
            openSession.commit();
            openSession.close();
        }
    }
}
