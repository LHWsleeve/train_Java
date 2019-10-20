package 深入JVM虚拟机;
/**
 * Java 300集
 */

import javax.swing.plaf.nimbus.State;

public class Demo01 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.width);
    }
}

class A{
    public static int width = 100;
    static {
        System.out.println("静态初始化类A");
        width = 300;
    }
    public A(){
        System.out.println("创建A类的对象");
    }
}
