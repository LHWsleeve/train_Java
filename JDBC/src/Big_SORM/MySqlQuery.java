package Big_SORM;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MySqlQuery implements Query {

    @Override
    public int executeDML(String sql, Object[] paramts) {
        return 0;
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
        String sql = "delect from "+tableInfo.getTname()+" where "+onlyPrikey.getName()+"=?";
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
