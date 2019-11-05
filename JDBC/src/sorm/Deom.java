package sorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Deom {
    public static void test() {
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Emp emp = null;

        {
            try {
                conn = JDBCUtil.getMySQLConn();
                String sql = "SELECT employee_id,last_name \n" +
                        "FROM employees \n" +
                        "WHERE employee_id>?;";
                ps = conn.prepareStatement(sql);
                ps.setObject(1, 160);
                rs = ps.executeQuery();
                while (rs.next()) {
                    emp = new Emp(rs.getInt(1), rs.getString(2));
                    System.out.println(emp.getEmployee_id() + "----" + emp.getLast_name());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test02() {
        Connection conn;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> emp = new ArrayList<>();
        {
            try {
                conn = JDBCUtil.getMySQLConn();
                String sql = "SELECT employee_id,last_name \n" +
                        "FROM employees \n" +
                        "WHERE employee_id>?;";
                ps = conn.prepareStatement(sql);
                ps.setObject(1, 160);
                rs = ps.executeQuery();
                while (rs.next()) {

                    Emp one = new Emp(rs.getInt(1), rs.getString(2));
                    emp.add(one);
                     }
                for (Emp a:emp
                     ) {
                    System.out.println(a.getEmployee_id() + "----" + a.getLast_name());

                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test02();
    }
}
