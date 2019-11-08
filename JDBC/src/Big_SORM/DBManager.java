package Big_SORM;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/**
 * 根据配置信息，位置链接对象的管理（增加连接池功能）
 */
public class DBManager {
    private static Configuration conf;
    static {
        Properties pros = new Properties();
        try {
            //得到当前的classpath的绝对路径的URI表示法。
            pros.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("Big_SORM/db.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf = new Configuration();
        conf.setDiver(pros.getProperty("diver"));
        conf.setPoPackage(pros.getProperty("PoPackage"));
        conf.setPwd(pros.getProperty("pwd"));
        conf.setSrcPath(pros.getProperty("srcPath"));
        conf.setUrl(pros.getProperty("url"));
        conf.setUser(pros.getProperty("user"));
        conf.setUsingDB(pros.getProperty("usingDB"));
        conf.setQuerClass(pros.getProperty("querClass"));
    }
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(conf.getDiver());
        Connection conn = DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());//目前直接建立连接，后期建立连接池提高效率
        return conn;
    }
    //返回Configuration对象
    public static Configuration getConf(){
        return  conf;
    }
}
