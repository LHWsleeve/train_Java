package TestDynamicCompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 测试动态编译
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        //通过IO操作，将字符串存储成一个临时文件，然后调用动态方法。可以实现编译str字符串。（这个操作就是网页在线编译器的实现方法）
        String str = "public class Hi" +
                "{\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"HaHa\");\n" +
                "    }\n" +
                "}";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "C:/Users/liuha/Documents/GitHub/train_Java/HelloWorld.java");//编译成功返回0
//        System.out.println(result==0?"成功":"失败");


        //Runtime.getRuntime()方法动态运行编译好的类，获取值
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp   C:/Users/liuha/Documents/GitHub/train_Java   HelloWorld");//HelloWorld类
        InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info = "";
        while ((info = reader.readLine()) != null) {
//            System.out.println(info);
        }

        //通过反射运行编译好的类（类加载器）
            try {
                URL[] urls = new URL[]{new URL("file:/" + "C:/Users/liuha/Documents/GitHub/train_Java/")};//最后这个目录符"/"一定要加，读取的类文件要在该目录下
                URLClassLoader loader = new URLClassLoader(urls);
                Class c = loader.loadClass("HelloWorld");
                //调用加载类的main方法
                Method m = c.getMethod("main", String[].class);
                m.invoke(null, (Object)new String[]{});//(object)强转型一定要加，因为JDK5.0之后才有可变参数。300集，276
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }