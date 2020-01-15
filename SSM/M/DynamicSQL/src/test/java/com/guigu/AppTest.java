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
import java.util.ArrayList;
import java.util.Arrays;
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
            teacher1.setTeacherName("%数%");
//            teacher1.setBirthDate(new Date());
            List<Teacher> list = mapper.getTeacherByCondition(teacher1);
            System.out.println("查询出的teacher："+list);

        }finally {
            openSession.commit();
            openSession.close();
        }
    }


    @Test
    public void test02(){
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            TeacherDao mapper = openSession.getMapper(TeacherDao.class);
            List<Teacher> idIn = mapper.getTeacherByIdIn(Arrays.asList(1, 2));
            System.out.println("查询出的teacher："+idIn);

        }finally {
            openSession.commit();
            openSession.close();
        }
    }
    @Test
    public void test03(){
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            TeacherDao mapper = openSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
//            teacher.setId(1);
//            teacher.setTeacherName("物理");
            List<Teacher> choose = mapper.getTeacherByConditionChoose(teacher);
            System.out.println("查询出的teacher："+choose);

        }finally {
            openSession.commit();
            openSession.close();
        }
    }
}
