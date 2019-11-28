package com.jdbc; /**
 * 测试事务
 *
 */

import java.sql.*;

public class Demo06 {
    public static void main(String[] args) throws SQLException {
        //加载驱动类
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部对象包含Socket对象，是一个远程链接。比较耗时
            // 真正开发中，为了提高效率，使用连接池连接对象)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC"//MySQL时区问题，在连接中加上serverTimezone=UTC
                    , "root", "123456");

            conn.setAutoCommit(false);

            String sql = "INSERT INTO jobs (job_id,job_title,min_salary,max_salary) " +
                    "VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,"IT");
            ps.setObject(2,"person");
            ps.setObject(3,"1000");
            ps.setObject(4,"2000");
            ps.execute();
            System.out.println("插入一条");

            Thread.sleep(2000);

            ps2 = conn.prepareStatement(sql);
            ps2.setObject(1,"IT");
            ps2.setObject(2,"person2");
            ps2.setObject(3,"3000");
            ps2.setObject(4,"4000");
            ps2.execute();
            System.out.println("插入第二条");


            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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