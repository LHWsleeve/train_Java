package com.sxt.dao.imp;

import com.sxt.dao.LoginDao;
import com.sxt.pojo.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        //声明JDBC对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建连接对象，获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=UTC","root", "123456");
            //创建Sql
            String sql = "select * from person where Name=? and Pwd=?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符复制
            ps.setObject(1,uname);
            ps.setObject(2,pwd);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()){
                u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPwd(rs.getString(3));
            }
            //关闭资源
            //返回
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return u;
    }

    @Override
    public User checkIdDao(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //声明数据存储对象
        User u = null;
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建连接对象，获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=UTC","root", "123456");
            //创建Sql
            String sql = "select * from person where Id=?";
            //创建sql命令对象
            ps = conn.prepareStatement(sql);
            //给占位符复制
            ps.setObject(1,id);
            //执行
            rs = ps.executeQuery();
            //遍历执行结果
            while (rs.next()){
                u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPwd(rs.getString(3));
            }
            //关闭资源
            //返回
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return u;
    }

}
