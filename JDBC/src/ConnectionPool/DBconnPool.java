package ConnectionPool;

import Big_SORM.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 连接池的类
 */
public class DBconnPool {

    private  List pool;
    private static final int POOL_MAX_SIZE=DBManager.getConf().getPoolMaxsize();
    private static final int POOL_MIN_SIZE=DBManager.getConf().getPoolMinsize();

    public void initPool() throws SQLException, ClassNotFoundException {
        if(pool==null){
            pool = new ArrayList();
        }
        while (pool.size()<DBconnPool.POOL_MIN_SIZE){
            pool.add(DBManager.creatConn());
            System.out.println("初始化，池中连接数："+pool.size());
        }
    }

    /**
     * 从连接池中取出链接（最后一个）
     * @return
     */
    public synchronized Connection getConn(){
        int lats_index = pool.size()-1;
        Connection conn = (Connection) pool.get(lats_index);
        pool.remove(lats_index);
        return conn;
    }

    /**
     * 链接放回连接池=关闭链接
     */
public synchronized void close(Connection conn) {
    if (pool.size() >= POOL_MAX_SIZE) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        pool.add(conn);
    }
}
    public DBconnPool() throws SQLException, ClassNotFoundException {
        initPool();
    }
}
