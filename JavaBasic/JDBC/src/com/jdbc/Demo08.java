package com.jdbc; /**
 * 测试时间处理2取出指定时间段的数据
 *
 */

import java.sql.*;
import java.util.Random;

public class Demo08 {
    public static void main(String[] args) throws SQLException {
        //加载驱动类
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部对象包含Socket对象，是一个远程链接。比较耗时
            // 真正开发中，为了提高效率，使用连接池连接对象)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=UTC"//MySQL时区问题，在连接中加上serverTimezone=UTC
                    , "root", "123456");

                String sql = "SELECT * FROM person WHERE date<?";
                ps = conn.prepareStatement(sql);
                Timestamp  time= new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(1,time);
                rs = ps.executeQuery();
                while (rs.next()){
                    System.out.println(rs.getString(2)+"----"+rs.getTimestamp(4));
                }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭顺序 resultset-->statment-->connection。三个关闭一定要分开写
            if (rs != null) {
                try {
                    rs.close();//后开的先关
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();//后开的先关
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}