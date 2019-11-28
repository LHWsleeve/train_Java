package Big_SORM;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.security.PublicKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责查询（对外提供服务核心类）
 */
public abstract class Query implements Cloneable{
    /**
     * 直接执行一个DML语句
     *
     * @return 执行sql语句后影响记录行数
     */
    public Object executeTemplate(String sql,Object[] params,Class clazz,CallBack back) {
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
           return back.doExeute(conn, ps, rs);

        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }  finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public int executeDML(String sql, Object[] paramts){
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
     * 执行插入sql语句
     */
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

    /**
     * 删除clazz表示类，对应表中记录（指定Id）
     */
    public void delect(Class clazz, Object id) {
        //通过class对象找TableInfo
        TableInfo tableInfo = TableContext.poclassTableMap.get(clazz);
        //获得主键
        ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();
        String sql = "delete from "+tableInfo.getTname()+" where "+onlyPrikey.getName()+"=?";
        executeDML(sql,new Object[]{id});
    }
    public void delect(Object obj) {
        Class c = obj.getClass();//获取当前对象的类
        TableInfo tableInfo = TableContext.poclassTableMap.get(c);
        ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();

        //通过反射，调用属性对应的get或set方法
        Object prikeyValue =  ReflectUtils.invokeGet(onlyPrikey.getName(),obj);
        delect(c,prikeyValue);
    }

    /**
     * 更新对象对应记录，并且只更新指定的字段值
     *
     * @param obj
     * @param filedName 更新属性列表
     * @return
     */
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

    /**
     * 查询返回多行记录，并将每行记录封装到CLAZZ指定类的对象中
     *
     * @param sql    查询语句
     * @param clazz  封装数据的javabean类的Class对象
     * @param params sql参数
     * @return 查询到的结果
     */
    public List queryRows(final String sql,final Class clazz,final Object[] params) {
        final List list = new ArrayList();
       return (List) executeTemplate(sql, params, clazz, new CallBack() {
           @Override
           public Object doExeute(Connection conn, PreparedStatement ps, ResultSet rs) {
               try {
                   List list = null;
                   ResultSetMetaData metaData = rs.getMetaData();
               while (rs.next()) {
                   if (list==null){
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
               }
               return list;
           }
       });
    }

    /**
     * 返回一行记录
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public Object queryUniqueRows(String sql, Class clazz, Object[] params) {
        List list = queryRows(sql,clazz,params);
        //一个
        return (list!=null&&list.size()!=0)?list.get(0):null;
    }

    /**
     * 查询返回一个值
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public Object queryValue(String sql, Class clazz, Object[] params) {
        Connection conn = null;
        PreparedStatement ps =null;
        Object value = null;//存储查询结果对象
        ResultSet rs = null;
        try {
            conn = DBManager.getConn();
            ps = conn.prepareStatement(sql);
            //给sql传参
            JDBCUtils.handlePa(ps,params);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                value = rs.getObject(1);
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
        return value;
    }

    /**
     * 返回一个数字
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public Number queryNumber(String sql, Class clazz, Object[] params) {
        return (Number) queryValue(sql,clazz,params);
    }

    /**
     * 根据主键的值直接查找对象
     * @param clazz
     * @param id
     * @return
     */
    public Object queryId(Class clazz, Object id){
        TableInfo tableInfo = TableContext.poclassTableMap.get(clazz);
        //获得主键
        ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();
        String sql = "select * from "+tableInfo.getTname()+" where "+onlyPrikey.getName()+"=?";
        executeDML(sql,new Object[]{id});
        return id;
    }
    public  abstract Object querypage(int pageNum, int size);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}