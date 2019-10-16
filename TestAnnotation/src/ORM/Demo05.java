package ORM;

import Reflect.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射API，动态操作构造器，方法，属性
 * 注意：反射会影响程序性能（安全检查），若不得不用反射可以使用setAccessible(true)绕过安全检测，提高效率
 */
public class Demo05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        String path = "Reflect.User";
        Class<User> clazz = (Class<User>) Class.forName(path);
       //通过反射API调用构造方法，构造对象
        User u =  clazz.newInstance(); //调用了User的无参构造方法(空构造方法)
        System.out.println(u);
        Constructor<User> c2 = clazz.getDeclaredConstructor(int.class, String.class, int.class);//记住传参顺序，顺序要和原构造器一致！！
        User u2 = c2.newInstance(1001, "A", 18);//构造构造器
        System.out.println(u2.getName());
        //通过反射API调用普通方法
        User u3 = clazz.newInstance();
//        u3.setName("A");
        Method method = clazz.getDeclaredMethod("setName", String.class);
        method.invoke(u3, "B");//等于25行代码。反射可以动态的调用方法，方法名都是变量

        //通过反射API操作属性
        User u4 = clazz.newInstance();
        Field f = clazz.getDeclaredField("name");
        f.setAccessible(true);//单纯的set是不能设置私有属性和方法的。但是setAccessible方法表示不需安全检查，直接访问。更改私有属性or放啊
        f.set(u4,"C");//反射直接写属性
        System.out.println(u4.getName());
        System.out.println(f.get(u4));//反射直接读属性



    }
}
