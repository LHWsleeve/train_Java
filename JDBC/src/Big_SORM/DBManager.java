package Big_SORM;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 根据配置信息，位置链接对象的管理（增加连接池功能）
 */
public class DBManager {
    public static Configuration conf;
    static {
        Properties pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.propertites"));
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
    }
    public static Connection getMySQLConn() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Class.forName(conf.getDiver());
        conn = DriverManager.getConnection
                (conf.getUrl(),conf.getUser(),conf.getPwd());//目前直接建立连接，后期建立连接池提高效率
        return conn;
    }
}
