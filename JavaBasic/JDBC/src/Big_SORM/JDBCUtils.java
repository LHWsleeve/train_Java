package Big_SORM;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装了JDBC查询常用操作
 */

/**
 * 给sql传参
 */
public class JDBCUtils {
    public static void handlePa(PreparedStatement ps, Object[] paramts){
        if (paramts!=null){
            for (int i = 0; i <paramts.length ; i++) {
                try {
                    ps.setObject(1+i,paramts[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
