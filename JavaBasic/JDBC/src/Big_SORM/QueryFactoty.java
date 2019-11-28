package Big_SORM;


/**
 * 工厂类
 */
public class QueryFactoty {
    private static QueryFactoty factory = new QueryFactoty();
    private static Query prototype;//原型对象

    static {
        try {
            Class c = Class.forName(DBManager.getConf().getQuerClass());
            try {
                prototype = (Query) c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private QueryFactoty() {
        //私有构造器
    }

    public static Query createQuery() {
        try {
            return (Query) prototype.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
