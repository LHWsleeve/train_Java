package Big_SORM;

/**
 * 封装表中一个字段信息
 *
 */
public class ColumnInfo {
    /**
     * 字段名称
     */
    private String name;
    /**
     * 字段的数据类型
     */
    private String dataType;

    /**
     * 字段键的类型（0：普通键，1：主键 2：外键）
     */
    private int KeyType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getKeyType() {
        return KeyType;
    }

    public void setKeyType(int keyType) {
        KeyType = keyType;
    }

    public ColumnInfo() {
    }

    public ColumnInfo(String name, String dataType, int keyType) {
        this.name = name;
        this.dataType = dataType;
        KeyType = keyType;
    }
}
