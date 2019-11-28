package com.jdbc; /**
 * 测试时间处理（java.sql.date,Time,Timestamp）
 *
 */

import java.sql.*;
import java.util.Random;

public class Demo07 {
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

            for (int i = 0; i <1000 ; i++) {

                String sql = "INSERT INTO person (Id,name,age,date) VALUES (?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setObject(1,i);
                ps.setObject(2,"person"+i);
                ps.setObject(3,"18");
                long rand = 2000000000+new Random().nextInt(1000000000);
                java.sql.Timestamp date = new Timestamp(System.currentTimeMillis()-rand);//如果需要插入指定日期，可任意插入Calendar，DateFormat类
                ps.setTimestamp(4,date);
                ps.execute();
            }
            System.out.println("插入一条");

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