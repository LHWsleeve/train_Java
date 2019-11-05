package Big_SORM;

import java.util.Map;

/**
 * 存储表结构信息
 */
public class TableInfo {
    /**
     * 表名
     */
    private String tname;
    /**
     * 所有字段信息
     */
    private Map<String,ColumnInfo> columns;
    /**
     * 主键:目前只能处理有且只有一个主键的情况
     */
    private ColumnInfo onlyPriKey;

    public TableInfo() {
    }

    public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
        this.tname = tname;
        this.columns = columns;
        this.onlyPriKey = onlyPriKey;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public ColumnInfo getOnlyPriKey() {
        return onlyPriKey;
    }

    public void setOnlyPriKey(ColumnInfo onlyPriKey) {
        this.onlyPriKey = onlyPriKey;
    }
}
