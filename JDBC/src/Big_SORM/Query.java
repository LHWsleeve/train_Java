package Big_SORM;

import java.util.List;

/**
 * 负责查询（对外提供服务核心类）
 */
public interface Query {
    /**
     * 直接执行一个DML语句
     *
     * @return 执行sql语句后影响记录行数
     */

    public int executeDML(String sql, Object[] paramts);

    /**
     * 执行插入sql语句
     */
    public void insert(Object obj);

    /**
     * 删除clazz表示类，对应表中记录（指定Id）
     */
    public void delect(Class clazz, Object id);

    public void delect(Object obj);

    /**
     * 更新对象对应记录，并且只更新指定的字段值
     *
     * @param obj
     * @param filedName 更新属性列表
     * @return
     */
    public int update(Object obj, String[] filedName);

    /**
     * 查询返回多行记录，并将每行记录封装到CLAZZ指定类的对象中
     *
     * @param sql    查询语句
     * @param clazz  封装数据的javabean类的Class对象
     * @param params sql参数
     * @return 查询到的结果
     */
    public List queryRows(String sql, Class clazz, Object[] params);

    /**
     * 返回一行记录
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public Object queryUniqueRows(String sql, Class clazz, Object[] params);

    /**
     * 查询返回一个值
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public Object queryValue(String sql, Class clazz, Object[] params);

    /**
     * 返回一个数字
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public Number queryNumber(String sql, Class clazz, Object[] params);

}