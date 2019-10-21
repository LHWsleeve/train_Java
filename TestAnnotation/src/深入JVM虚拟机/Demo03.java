package 深入JVM虚拟机;

/**
 * 测试自定义的FileSystemClassLoader
 */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        FileSystemClassLoader loader = new FileSystemClassLoader("C:\\Users\\liuha\\Documents\\GitHub\\train_Java");
        Class<?> c = loader.loadClass("HelloWorld");
        Class<?> c2 = loader.loadClass("java.lang.String");
        Class<?> c3 = loader.loadClass("ORM.Demo03");

        System.out.println(c2.getClassLoader());//为空，引导类加载器
        System.out.println(c.getClassLoader());//自定义类加载器
        System.out.println(c3.getClassLoader());//（默认的加载器）系统加载器


        System.out.println(c);//并且只有同一个类被同一个加载器加载JVM才会认为是不同的类。（hashcode不同）
    }
}
