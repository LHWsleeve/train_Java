package Reflect;

import java.awt.desktop.SystemSleepEvent;

/**
 * 测试java.lang.Class对象获取方式
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        String path = "Reflect.User";
        Class clazz = Class.forName(path);
        //一个类被加载后，JVM会创建一个对应该类的Class对象，包含类的结构信息
        //这个Class对象可以看到类的全部信息。
        System.out.println(clazz.hashCode());
        Class calzz2 = Class.forName(path);
        System.out.println(calzz2.hashCode());
        //clazz2=clazz,即一个类只能对应一个Class对象
        Class strClass = String.class;
        Class strClass2 = path.getClass();
        System.out.println(strClass==strClass2);
        //两种方式获取Class，二者一样

        int[]a1 = new int[10];
        int[][]a2 = new int[30][3];
        int[][]a3 = new int[3][3];
        Class intClazz = a1.getClass();
        Class intClazz2 = a2.getClass();
        //当维度，属性相同时，二者同样一样。即，维度，double，int也一样才行
        System.out.println(intClazz.hashCode()+"\n"+intClazz2.hashCode());


    }

}
