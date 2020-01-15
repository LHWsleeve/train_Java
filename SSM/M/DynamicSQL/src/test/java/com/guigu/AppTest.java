package com.guigu;

import com.guigu.bean.Teacher;
import com.guigu.dao.TeacherDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
            TeacherDao mapper = openSession.getMapper(TeacherDao.class);
            Teacher teacher1 = new Teacher();
            teacher1.setId(1);
            teacher1.setTeacherName("%文%");
            teacher1.setBirthDate(new Date());
            List<Teacher> list = mapper.getTeacherByCondition(teacher1);
            System.out.println("查询出的teacher："+list);

        }finally {
            openSession.commit();
            openSession.close();
        }
    }

}
