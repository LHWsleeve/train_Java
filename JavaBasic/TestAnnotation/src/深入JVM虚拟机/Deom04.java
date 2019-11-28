package 深入JVM虚拟机;

/**
 * 测试简单的加密解密操作
 */
public class Deom04 {
    public static void main(String[] args) throws ClassNotFoundException {
//        测试取反过程
//        int a = 3;
//        System.out.println(Integer.toBinaryString(a^0xff));
    DecrptClass loader = new DecrptClass("C:\\Users\\liuha\\Documents\\GitHub\\train_Java\\temp");
    Class<?> c = loader.loadClass("HelloWorld");
        System.out.println(c);



    }
}

