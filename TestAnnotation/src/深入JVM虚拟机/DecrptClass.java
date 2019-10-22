package 深入JVM虚拟机;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 定义解密类
 */
public class DecrptClass extends ClassLoader {
    //类名--->在指定目录下面找该类
    private  String rootDir;
    public DecrptClass(String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        //先查询有没有加载这个类，若有直接返回，若没有加载新的类
        if (c!=null){
            return c;
        }else {
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);  //委派给父类

            }catch (Exception e){
//                e.printStackTrace();
            }
            if(c!=null){
                return c;
            }else {
                byte[] classDate = new byte[0];
                try {
                    classDate = getClassData(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (classDate==null){
                    throw new ClassNotFoundException();
                }else {
                    c = defineClass(name,classDate,0,classDate.length);
                }

            }
        }
        return c;
    }

    private byte[] getClassData(String classname) throws IOException {
        String path = rootDir+"/"+classname.replace(',','/')+".class";
        //IOUtils,可以使用它将流中数据转成字节数组
        InputStream is = new FileInputStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //下面两条相当于取反解密过程
        int temp = -1;
        while((temp=is.read())!=-1){
            baos.write(temp^0xff);//取反操作
        }
        if (is==null){
            is.close();
        }
        return baos.toByteArray();
    }
}
