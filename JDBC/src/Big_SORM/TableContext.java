package Big_SORM;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责管理数据库所有表结构和类结构的关系,并可以更具表结构生成类结构
 */
public class TableContext {
    /**
     *表名为key,表信息对象为value
     */
    public static Map<String,TableInfo> tables=new HashMap<String,TableInfo>();
/**
 *将po的c1ass对象和表信息对象关联起来,便于重用！
 */
 public static Map<Class,TableInfo> poclassTableMap=new HashMap<Class,TableInfo>();
    private TableContext(){}
    static {
        try {
//初始化获得表的信息
            Connection con = DBManager.getConn();
            DatabaseMetaData dbmd = con.getMetaData();
            ResultSet tableRet = dbmd.getTables(null, "%", "%", new String[]{"TABLE"});
            while (tableRet.next()) {
                String tableName = (String) tableRet.getObject("TABLE_NAME");
                TableInfo ti = new TableInfo(tableName, new ArrayList<>(), new HashMap<>());
                tables.put(tableName, ti);
                ResultSet set = dbmd.getColumns(null, "%", tableName, "%");//查询表中的所有字段
                while (set.next()) {
                    ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),
                            set.getString("TYPE_NAME"), 0);
                    ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
                }
                ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tableName);//查询t_user表中的主键
                while (set2.next()) {
                    ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
                    ci2.setKeyType(1);//设置为主键类型
                    ti.getPriKeys().add(ci2);
                }
                if (ti.getPriKeys().size() > 0) {//取唯一主键。。方便使用。如果是联含主键。则为空！
                    ti.setOnlyPriKey(ti.getPriKeys().get(0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 每次启动，更新类结构
         */
        updateJavaPOFile();
        /**
         * j加载po包下面所有的类便于重用
         */
        loadPOtable();
    }

    /**
     * 根据表结构，更新配置po包下面的java类
     * 实现从表结构到类结构
     */
    public static void updateJavaPOFile() {
        Map<String, TableInfo> tables = TableContext.tables;
        for (TableInfo t : tables.values()) {
            JavaFileUtils.createJavaPOFile(t, new MySQLTypeConbertor());
        }
    }

    /**
     * 加载po包的类
     */
    public static void loadPOtable(){
        for (TableInfo t: tables.values()){
            try {
                Class c = Class.forName(DBManager.getConf().getPoPackage()+"."
                        +StringUtils.firstChar2UpperCase(t.getTname()));
                poclassTableMap.put(c,t);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

            public static void main (String[]args){
                Map<String, TableInfo> tables = TableContext.tables;
                System.out.println(tables);
            }
        }