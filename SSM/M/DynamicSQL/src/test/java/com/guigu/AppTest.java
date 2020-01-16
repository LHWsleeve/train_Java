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



    @Test
    public void test04(){
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            TeacherDao mapper = openSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setTeacherName("化学");
            int i = mapper.updateTeacher(teacher);
            System.out.println("更新结果："+i);
        }finally {
            openSession.commit();
            openSession.close();
        }
    }

    /**
     * 测试缓存：
     * 一级缓存失效的情况:一级缓存是SqlSession级别的缓存；
     * 1.不同的sqlSession使用不同的一级缓存。
     *          只有在当前同一个sqlsession期间，查询到的数据会保存在这个sqlsession的缓存中，下次使用才从这个缓存中拿
     * 2.同一个方法，不同的参数。由于可能之前没查过，所以还会发新的sql
     * 3.在sqlsession期间，执行任何一次增删改操作。增删改操作会清空缓存
     * 4.手动清空缓存
     * 每次查询，先看一级缓存中有没有，如果没有就去发送新的sql；每个sqlsession拥有自己的一级缓存
     */
    @Test
    public void test05(){
        //1.第一个会话
        SqlSession openSession = sqlSessionFactory.openSession();
        TeacherDao mapper = openSession.getMapper(TeacherDao.class);
        Teacher teacher1 = mapper.getTeacherById(1);
        System.out.println(teacher1+"\n");

        //在两个查询之间增加一个curd操作
        Teacher teacher = new Teacher();
        teacher.setId(3);
        teacher.setTeacherName("hahahahah");
        mapper.updateTeacher(teacher);
        System.out.println(mapper.getTeacherById(1)+"\n");

        //手动清缓存
//        openSession.clearCache();//这条执行，则下面的一级缓存示例失败
        //一级缓存示例
        Teacher teacher4 = mapper.getTeacherById(1);
        System.out.println(teacher4+"\n");

        //相同sqlsession不同查询条件
        Teacher teacher3 = mapper.getTeacherById(2);
        System.out.println(teacher3+"\n");

        //第二个会话
        SqlSession openSession2 = sqlSessionFactory.openSession();
        TeacherDao mapper2 = openSession2.getMapper(TeacherDao.class);
        Teacher teacher2 = mapper2.getTeacherById(1);
        System.out.println(teacher2+"\n");

        openSession.close();
        openSession2.close();
    }
}
