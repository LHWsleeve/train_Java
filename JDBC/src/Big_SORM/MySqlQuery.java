package Big_SORM;

import po.Employees;
import sorm.JDBCUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class MySqlQuery implements Query {
public static void testDML(){
    Employees e =new Employees();
    e.setEmployee_id(206);
//        new MySqlQuery().delect(e);
    e.setDepartment_id(50);
    e.setJob_id("IT_PROG");
    e.setLast_name("xxxxx");
    e.setFirst_name("b");
    e.setSalary((double) 13000);
//        new MySqlQuery().insert(e);
    new MySqlQuery().update(e,new String[]{"Last_name"});
}

    public static void main(String[] args) {
       List list = new MySqlQuery().queryRows("select * from employees where employee_id>? and salary>?"
       ,Employees.class,new Object[]{200,5000});
        System.out.println(list);
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
        //update table set xx=?,xx=? where id=?
        Class c = obj.getClass();
        List<Object> params = new ArrayList<>();//存储sql的参数
        TableInfo tableInfo = TableContext.poclassTableMap.get(c);
        ColumnInfo priKey = tableInfo.getOnlyPriKey();
        StringBuilder sql = new StringBuilder("update "+tableInfo.getTname()+" set ");

        for (String fname:filedName){
            Object fvalue = ReflectUtils.invokeGet(fname,obj);
            params.add(fvalue);
            sql.append(fname+"=?,");
            sql.setCharAt(sql.length()-1,' ');
            sql.append(" where ");
            sql.append(priKey.getName()+"=?");
            params.add(ReflectUtils.invokeGet(priKey.getName(),obj));//最后一个是，获得主键值

            return executeDML(sql.toString(),params.toArray());

        }
        return 0;
    }

    @Override
    public List queryRows(String sql, Class clazz, Object[] params) {
        Connection conn = null;
        PreparedStatement ps =null;
        List list = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConn();
            ps = conn.prepareStatement(sql);
            //给sql传参
            JDBCUtils.handlePa(ps,params);
            System.out.println(ps);
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                while (list==null){
                    list = new ArrayList();
                }
            Object rowObj = clazz.getDeclaredConstructor().newInstance();
            for (int i=0; i<metaData.getColumnCount();i++) {
                String columnNmae = metaData.getColumnLabel(i+1);
                Object columnValue = rs.getObject(i+1);
                //调用rowobj对象的setUsername（String uname）方法，将columnValue的值设置进去
                ReflectUtils.invoSet(rowObj,columnNmae,columnValue);
            }
                list.add(rowObj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
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
