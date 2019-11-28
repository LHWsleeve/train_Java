package Big_SORM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface CallBack {
    public Object doExeute(Connection conn, PreparedStatement ps, ResultSet rs);
}
