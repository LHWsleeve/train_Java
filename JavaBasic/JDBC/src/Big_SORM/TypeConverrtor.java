package Big_SORM;

/**
 * 负责java数据类型和数据库类型的互相转换
 */
public interface TypeConverrtor {
    /**
     * 将数据库类型转化成java数据类型
     * @param columnType
     * @return java数据类型
     */
    public String databaseType2JavaType(String columnType);

    /**
     * 将java数据类型转换成数据库类型
     * @param javaDatatype
     * @return
     */
    public String javaType2DatabaseType(String javaDatatype);


}
