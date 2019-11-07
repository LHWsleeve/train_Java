package Big_SORM;

/**
 * MySQL数据类型和java数据类型转换
 */
public class MySQLTypeConbertor implements TypeConverrtor{
    @Override
    public String databaseType2JavaType(String columnType) {
        //varchar-->String
        if ("varchar".equalsIgnoreCase(columnType)|"char".equalsIgnoreCase(columnType)) {
            return "String";
        }else if ("int".equalsIgnoreCase(columnType)|
                "tinyint".equalsIgnoreCase(columnType)|
                "smallint".equalsIgnoreCase(columnType)|
                "integerint".equalsIgnoreCase(columnType)){
            return "Integer";
        }else if ("bigint".equalsIgnoreCase(columnType)){
            return "Long";
        }else if ("double".equalsIgnoreCase(columnType)|
                "float".equalsIgnoreCase(columnType)){
            return "Double";
        }else if ("blob".equalsIgnoreCase(columnType)){
            return "java.sql.blob";
        } else if ("time".equalsIgnoreCase(columnType)){
        return "java.sql.Time";
         } else if ("timestamp".equalsIgnoreCase(columnType)){
        return "java.sql.Timestamp";
        }else if ("datetime".equalsIgnoreCase(columnType)){
            return "Date";
        }
        return null;
    }


    @Override
    public String javaType2DatabaseType(String javaDatatype) {
        return null;
    }
}
