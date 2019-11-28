package com.jdbc; /**
 * 测试CLOB(文本大对象)使用
 *
 */

import java.io.*;
import java.sql.*;

public class Demo09 {
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

                String sql = "INSERT INTO person (Id,name,MyInfo) VALUE (?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setObject(1,2);
                ps.setObject(2,"张三");
//                ps.setClob(3,new FileReader(new File("src\\gongzi.txt")));//将文本文件内容直接输入数据库

            //将程序中的字符串输入到CLOB中
//            ps.setClob(3,new BufferedReader
//                    (new InputStreamReader(new ByteArrayInputStream("123456".getBytes()))));//CLOB必须是一个流，所以要转换


            String sql2 = "SELECT MyInfo FROM person WHERE Id=1";
            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();
            while (rs.next()){
//                Clob c = rs.getClob("MyInfo");
//                Reader r = c.getCharacterStream();
//                int temp=0;
//                while ((temp=r.read())!=-1){
//                    System.out.print((char)temp);
//                }
                System.out.println(rs.getClob(1));//返回一个对象地址
                System.out.println(rs.getObject(1));//返回对象内容（一个整体），所以println/print不换行。
                // 上面流形式按照字节返回，换行
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
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