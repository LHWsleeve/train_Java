package 深入JVM虚拟机;

import java.io.*;

/**
 * 自定义文件系统类加载器
 */
public class FileSystemClassLoader extends ClassLoader {
    //类名--->在指定目录下面找该类
    private  String rootDir;
    public FileSystemClassLoader(String rootDir){
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
        byte[] buffer = new byte[1024];
        int temp = 0;
        while ((temp=is.read(buffer))!=-1){
            baos.write(buffer,0,temp);
        }
        if (is==null){
        is.close();
        }
        return baos.toByteArray();
    }
}
