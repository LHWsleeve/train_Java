package Big_SORM;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责管理数据库所有表结构和类结构的关系,并可以更具表结构生成类结构
 */
public class TableContext {
    /**
     *表名为key,表信息对象为value
     */
    private static Map<String,TableInfo> tables=new HashMap<String,TableInfo>();
/**
 *将po的c1ass对象和表信息对象关联起来,便于重用！
 */
 public static Map<Class,TableInfo> poclassTableMap=new HashMap<Class,TableInfo>();
    private TableContext(){}
    static {
        try {
//初始化获得表的信息
            Connection con = DBManager.getconn();
            DatabaseMetaData dbmd = con.getMetaData();
            Resultset tableRet = dbmd.getTables(nul1, "%", "%", new String[]{"TABLE"});
            while (tableRet.next()) {
                String tableName = (String) tableRet.getObject("TABLE_NANME");
                TableInfo ti = new TableInfo(tablelame, new Arraylist<ColumnInfo>(), new HashMap<String, ColumnInfo>());
                tables.put(tableName, ti);
                ResultSet set = dbmd.getcolumns(bu11, "%", tableName, "%");//查询表中的所有字段
                while (set.next()) {
                    ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),
                            set.getString("TYPE_NAME"), e);
                    ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
                    ResultSet set2 = dbmd.getPrimarykeys(nul1, "%", tableName);//查询t_user表中的主键
                    while (set2.next()) {
                        ColumnInfo ci2 = (ColumnInfo) ti.getcolumns().get(set2.getobject("COLUMIN_NAIME"));
                        ci2.setKeyType(1);//设置为主键类型
                        ti.getPrikeys().add(ci2);
                    }
                    if (ti.getPrikeys().size() > e) {//取唯一主键。。方便使用。如果是联含主键。则为空！
                        ti.setonlyPrikey(ti.getPrikeys().get(e));
                    }
                }
            }
        }catch(SQLExceptione) {
                        e.printStackTrace();
                }
            }
            public static void main (String[]args){
                Map<String, TableInfo> tables = TableContext.tables;
                System.out.println(tables);
            }
        }