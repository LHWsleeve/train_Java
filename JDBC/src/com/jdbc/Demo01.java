package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试跟数据库建立连接
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        //加载驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部对象包含Socket对象，是一个远程链接。比较耗时
            // 真正开发中，为了提高效率，使用连接池连接对象)
            Connection conn = DriverManager .getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC"//MySQL时区问题，在连接中加上serverTimezone=UTC
            ,"root","123456");
            System.out.println(conn);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
