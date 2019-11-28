package com.jdbc; /**
 * 测试批处理
 * 注：对于大量的批处理，建议使用Statement，因为PreoareStatement的预编译空间有限，当数据量特别大时会发生异常
 *  *
 */

import java.sql.*;

public class Demo05 {
    public static void main(String[] args) {
        //加载驱动类
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部对象包含Socket对象，是一个远程链接。比较耗时
            // 真正开发中，为了提高效率，使用连接池连接对象)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC"//MySQL时区问题，在连接中加上serverTimezone=UTC
                    , "root", "123456");

            conn.setAutoCommit(false);//设置手动提交

            stmt = conn.createStatement();

            for (int i = 1; i <20000 ; i++) {
                stmt.addBatch("INSERT INTO person(Id,`name`) VALUES(i,"+"张"+i+")");
            }

            stmt.executeBatch();

             conn.commit();

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
            if (stmt != null) {
                try {
                    stmt.close();//后开的先关
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