package 深入JVM虚拟机;
/**
 * Java 300集 280-281
 */

import javax.swing.plaf.nimbus.State;
import java.awt.desktop.SystemSleepEvent;

public class Demo01 {
    static {
        System.out.println("Demo01静态初始化块");
    }

    public static void main(String[] args) {
//        System.out.println("Demo01");
//        A a = new A();
//        System.out.println(A.width);
//        A a2 = new A();//第二次new新对象不会再出现静态初始化的块内容！类的加载和初始化只进行一次！！！！
        System.out.println(A.MAX);//final常量不会发生初始化(常量池里的内容都不会初始化类)
    }
}

class A extends A_Father{
    public static final int MAX =100;
    public static int width = 100;//静态变量,静态域 field
    static {
        System.out.println("静态初始化类A");
        width = 300;
    }
    public A(){
        System.out.println("创建A类的对象");
    }
}

class  A_Father{
    static {
        System.out.println("静态初始化A_Father");
    }
}
