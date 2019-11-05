package com.jdbc;

import java.sql.*;

public class JDBCUtil {

    public static Connection getMySQLConn() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/myemployees?serverTimezone=UTC","root", "123456");
        return conn;
    }
}
