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

    @Test
    public void test01(){
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee(null, "bbb", "ccc@", 1, "bbbbbbbbb");
            int i = mapper.insertEmp(employee);
            System.out.println("插入成功："+i);
            System.out.println("刚才插入的id:"+employee.getId());
        }finally {
            openSession.commit();
            openSession.close();
        }
    }
}
