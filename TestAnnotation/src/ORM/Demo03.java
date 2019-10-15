package ORM;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解信息
 */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
       Class clazz =  Class.forName("ORM.SxtStudent");
       //获得类的所有注解
       Annotation[] annotatiom = clazz.getDeclaredAnnotations();
       for (Annotation a:annotatiom){
           System.out.println(a);
       }
       //另一种获得注解的方式，并且获得类指定注解的值
       Table st = (Table) clazz.getAnnotation(Table.class);
       System.out.println(st.value());
       //获得属性注解
        Field f = clazz.getDeclaredField("name");//name属性
        sxtField field = f.getAnnotation(sxtField.class);
        System.out.println(field.columnName()+"--->"+field.type()+"---->"+field.lenth());
        //根据获得的表明。字段信息，频出SQL语句注入数据库
    }
}
