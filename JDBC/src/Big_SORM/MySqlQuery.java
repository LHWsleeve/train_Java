package Big_SORM;

import po.Employees;
import sorm.JDBCUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySqlQuery implements Query {

    public static void main(String[] args) {
        Employees e =new Employees();
        e.setEmployee_id(206);
        new MySqlQuery().delect(e);
    }

    @Override
    public int executeDML(String sql, Object[] paramts) {
        Connection conn = null;
        PreparedStatement ps =null;
        int count = -1;
        try {
            conn = DBManager.getConn();
            ps = conn.prepareStatement(sql);
            //给sql传参
            JDBCUtils.handlePa(ps,paramts);
            System.out.println(ps);
            count = ps.executeUpdate();
            System.out.println(count);
            return count;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sql语义错误");
        return count;
    }

    @Override
    public void insert(Object obj) {

    }

    @Override
    public void delect(Class clazz, Object id) {
        //通过class对象找TableInfo
        TableInfo tableInfo = TableContext.poclassTableMap.get(clazz);
        //获得主键
        ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();
        String sql = "delete from "+tableInfo.getTname()+" where "+onlyPrikey.getName()+"=?";
        executeDML(sql,new Object[]{id});
    }

    @Override
    public void delect(Object obj) {
        Class c = obj.getClass();
        TableInfo tableInfo = TableContext.poclassTableMap.get(c);
        ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();

        //通过反射，调用属性对应的get或set方法
        Object prikeyValue =  ReflectUtils.invokeGet(onlyPrikey.getName(),obj);
        delect(c,prikeyValue);
    }

    @Override
    public int update(Object obj, String[] filedName) {
        return 0;
    }

    @Override
    public List queryRows(String sql, Class clazz, Object[] params) {
        return null;
    }

    @Override
    public Object queryUniqueRows(String sql, Class clazz, Object[] params) {
        return null;
    }

    @Override
    public Object queryValue(String sql, Class clazz, Object[] params) {
        return null;
    }

    @Override
    public Number queryNumber(String sql, Class clazz, Object[] params) {
        return null;
    }
}
