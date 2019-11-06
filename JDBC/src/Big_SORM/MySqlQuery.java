package Big_SORM;

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
    public int delect(Class clazz, int id) {
        //通过class对象找TableInfo
        TableContext.poclassTableMap.get(id);
        return 0;
    }

    @Override
    public void delect(Object obj) {

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
