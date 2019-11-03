package com.jdbc; /**
 * 测试PrepareStatement的基本用法
 *
 */
import java.sql.*;

public class Demo03 {
    public static void main(String[] args) {
        //加载驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部对象包含Socket对象，是一个远程链接。比较耗时
            // 真正开发中，为了提高效率，使用连接池连接对象)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=UTC"//MySQL时区问题，在连接中加上serverTimezone=UTC
                    , "root", "123456");
            String sql = " INSERT INTO person(Id,`name`) VALUES(?,?)";//？占位符，可以避免SQL注入
            PreparedStatement ps = conn.prepareStatement(sql);
//            第一种插入方式
//            ps.setString(1,"1");//参数索引从1开始算
//            ps.setString(2,"张三");
//            ps.execute();


//            第二种传入方式
            ps.setObject(1,"1");//全认为是object类型，随意插入。第一种方式需要用不同的setxxx类型插入
            ps.setObject(2,"张三");
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}