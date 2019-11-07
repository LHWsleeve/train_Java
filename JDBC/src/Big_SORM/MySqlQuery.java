package Big_SORM;

import po.Employees;
import sorm.JDBCUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class MySqlQuery implements Query {

    public static void main(String[] args) {
        Employees e =new Employees();
        e.setEmployee_id(206);
//        new MySqlQuery().delect(e);
        e.setDepartment_id(50);
        e.setJob_id("IT_PROG");
        e.setLast_name("a");
        e.setFirst_name("b");
        e.setSalary((double) 13000);
        new MySqlQuery().insert(e);
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

    /**
     * 对象存储到入数据库
     * 对象不为null
     * @param obj
     */
    @Override
    public void insert(Object obj) {
//obj-->表中 insert into table () values(?,?);
       Class c = obj.getClass();
       List<Object> params = new ArrayList<>();//存储sql的参数
       TableInfo tableInfo = TableContext.poclassTableMap.get(c);
       StringBuilder sql = new StringBuilder("insert into "+tableInfo.getTname()+"(");
       int countNotNull = 0;//计算不为空的属性
       Field[] fs  =  c.getDeclaredFields();
        for (Field f:fs) {
            String fieldName = f.getName();
            Object fieldValue = ReflectUtils.invokeGet(fieldName,obj);
            if(fieldValue!=null){
                countNotNull++;
                sql.append(fieldName+",");
                params.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length()-1, ')');
        sql.append(" values (");
        for (int i = 0; i <countNotNull ; i++) {
           sql.append("?,");
        }
        sql.setCharAt(sql.length()-1,')');
        executeDML(sql.toString(),params.toArray());
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
        Class c = obj.getClass();//获取当前对象的类
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
