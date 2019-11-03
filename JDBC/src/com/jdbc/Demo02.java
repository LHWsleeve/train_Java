package com.jdbc; /**
 * 测试Statement执行sql，以及sql注入
 */
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) {
        //加载驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接内部对象包含Socket对象，是一个远程链接。比较耗时
            // 真正开发中，为了提高效率，使用连接池连接对象)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=UTC"//MySQL时区问题，在连接中加上serverTimezone=UTC
                    , "root", "123456");
            //statement不常用。并且容易发生sql注入的危险
            Statement stmt = conn.createStatement();
//            String sql = "INSERT INTO person(Id,`name`) VALUES(1,\"张三\"); ";
//            stmt.execute(sql);
            //测试SQL注入(statement,接受外界参数需要拼接字符串，这个操作极其容易造成sql注入)
            String del = "DELETE FROM user WHERE Id=1";
            stmt.execute(del);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}