package Server_study01;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：吧java类中的各种结构（方法.属性、构造器、类名）映射成一个个的Java对象
 * 1.获取class对象（三种方式）
 * 2.可以动态创建
 * clz.getConstructor().newInstance()
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //（三种方式）
        //对象.getClass
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        //2.类.classs
        clz = Iphone.class;
        //3.Class.forNmae("包名.类名")
        clz = Class.forName("Server_study01.Iphone");

        //创建对象
        Iphone iphone1 = (Iphone)clz.getConstructor().newInstance();
        System.out.println(iphone1);
    }
}

class Iphone{
    public Iphone(){}


}

