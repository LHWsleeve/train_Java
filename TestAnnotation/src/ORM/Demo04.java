package ORM;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射API，获取类的信息（类名，属性，放啊，构造器）
 */
public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        String path = "Reflect.User";
        Class clazz = Class.forName(path);
        //获取类名
        System.out.println(clazz.getName());//获得包名+类名
        System.out.println(clazz.getSimpleName());//获得类名

        //获得相关属性
        Field[] field = clazz.getFields();//只能获得public的属性
        Field[] fields = clazz.getDeclaredFields();//返回所有属性,即返回所有类型的属性，都需要declaredxx方法
//        Field field03 = null;//获得指定名称的属性
//        try {
//            field03 = clazz.getField("id");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//            System.out.println("非public或者不存在");
//        }
//        System.out.println(field03);
        System.out.println(field.length);
        System.out.println(fields.length);
        //方法
        Method[] method = clazz.getMethods();//public
        Method[] methods = clazz.getDeclaredMethods();//全部
//        Method m = clazz.getDeclaredMethod("getname",parameterTypes);//钱一个是方法名，后一个参数是方法的参数（主要对应重载）
        Method m2 = clazz.getDeclaredMethod("setAge", int.class);
        for (Method m:methods){
            System.out.println("方法:"+m);
        }

        //构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c:constructors){
            System.out.println("构造器:"+c );
        }

    }
}
