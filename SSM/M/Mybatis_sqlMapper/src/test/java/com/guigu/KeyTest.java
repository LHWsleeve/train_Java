package com.guigu;

import com.guigu.bean.Key;
import com.guigu.bean.Lock;
import com.guigu.dao.LockDao;
import com.guigu.dao.keyDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class KeyTest {
    SqlSessionFactory sqlSessionFactory;

    @Before//这个注解表示每次test运行之前，这个方法先运行
    public void init() throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 联合查询情况下
     * 1、使用级联属性封装联合查询后的所有结果
     */

    @Test
    public void test01() {
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            keyDao keyDao = openSession.getMapper(keyDao.class);
            Key key = keyDao.getKeyById(1);
            System.out.println("查找成功：" +key );
        } finally {
            openSession.commit();
            openSession.close();
        }
    }

    //测试集合属性
    @Test
    public void test02() {
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            LockDao LockDao = openSession.getMapper(LockDao.class);
            Lock lock = LockDao.getLockById(3);
            System.out.println("查找成功：" +lock );
            System.out.println("所有的锁如下：");
            List<Key> keys = lock.getKeys();
            for(Key key: keys){
                System.out.println(key);
            }
        } finally {
            openSession.commit();
            openSession.close();
        }
    }
}
