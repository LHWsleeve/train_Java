package Big_SORM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 封装了生成java源文件操作
 */
public class JavaFileUtils {
    /**
     * 根据字段信息生成java属性信息。如 bar username->private String username
     * @param column 字段信息
     * @param convertor 类型转化其
     * @return 返回java属性和set/get方法源码
     */
    public static JavaFieldGetSet createFieldGetSet(ColumnInfo column, TypeConverrtor convertor){
        JavaFieldGetSet jfgs = new JavaFieldGetSet();
        String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
        jfgs.setFieldInfo("\tprivate "+javaFieldType+" "+column.getName()+";\n");
        //public String getUsername(){return username};
        //生成get源码
        StringBuilder getSrc = new StringBuilder();
        getSrc.append("\tpublic "+ javaFieldType+" get"+
                StringUtils.firstChar2UpperCase(column.getName())+"()\n");
        getSrc.append("\treturn "+column.getName()+";\n");
        getSrc.append("\t}\n");
        jfgs.setGetdInfo(getSrc.toString());
        //生成set源码
        //public void setUsername(String username){this.username=username}
        StringBuilder setSrc = new StringBuilder();
        setSrc.append("\tpublic void set"+ StringUtils.firstChar2UpperCase(column.getName())+"(");
        setSrc.append(javaFieldType+" "+column.getName()+"){\n");
        setSrc.append("\tthis."+column.getName()+"="+column.getName()+";\n");
        setSrc.append("\t}\n");
        jfgs.setSetInfo(setSrc.toString());
        return jfgs;
    }

    /**
     * 根据表信息生成jaca类的源代码
     * @param tableInfo
     * @param converrtor
     * @return java类源代码
     */
    public static  String createJavaSrc(TableInfo tableInfo, TypeConverrtor converrtor){
        Map<String,ColumnInfo> column = tableInfo.getColumns();
        List<JavaFieldGetSet> javaFields = new ArrayList<>();
        for (ColumnInfo c:column.values()){
            javaFields.add(createFieldGetSet(c,converrtor));
        }
        StringBuilder src = new StringBuilder();
        //package语句
        src.append("package"+DBManager.getConf().getPoPackage()+";\n\n");
        //import语句
        src.append("import java.sql.*\n");
        src.append("import java.util.*\n\n");
        //生成类声明语句
        src.append("public class "+
                StringUtils.firstChar2UpperCase(tableInfo.getTname())+"{\n\n");
        //属性列表
        for (JavaFieldGetSet jf:javaFields){
            src.append(jf.getFieldInfo());
        }
        src.append("\n\n");
        //get方法
        for (JavaFieldGetSet jf:javaFields){
            src.append(jf.getGetdInfo());
        }
        src.append("\n\n");
        //set方法
        for (JavaFieldGetSet jf:javaFields){
            src.append(jf.getSetInfo());
        }
        src.append("\n\n");
        //类结束
        src.append("}\n");
        System.out.println(src);
        return src.toString();
    }




    public static void main(String[] args) {
//        ColumnInfo ci = new ColumnInfo("username","varchar",0);
//        JavaFieldGetSet f = createFieldGetSet(ci, new MySQLTypeConbertor());
//        System.out.println(f);

        Map<String,TableInfo> tables = TableContext.tables;
        TableInfo t = tables.get("employees");
        createJavaSrc(t,new MySQLTypeConbertor());
    }
}
